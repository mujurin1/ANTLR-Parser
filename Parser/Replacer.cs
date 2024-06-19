using Antlr4;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using System;
using System.Linq;
using static Antlr4.AnalyzeParser;

/*
 * プログラムで利用する g4 ファイルは csproj に定義する必要がある
 * 
 * 必要なする nuget パッケージは２つ
 *  * Antlr4.Runtime.Standard
 *  * Antlr4BuildTasks
 * 
 * ANTLR はjavaのアプリで本来は jar ファイルをダウンロードして、
 * 実行して、言語用のファイルを生成して、利用する
 * けど Antlr4BuildTasks が変わりに全部やってくれるやつ。便利
 */

namespace Parser
{
    public static class Replacer
    {
        public static IResultType[] Replace(string str)
        {
            var inputStream = new AntlrInputStream(str);
            var lexer = new AnalyzeLexer(inputStream);
            var commonTokenStream = new CommonTokenStream(lexer);
            var parser = new AnalyzeParser(commonTokenStream);
            var visitor = new AnalyzeBaseVisitor<string>();
            var graphContext = parser.parse();

            return graphContext.children
                .Select(Convert)
                .ToArray();
        }

        public static IResultType Convert(IParseTree tree)
        {
            return tree switch {
                // どれにもマッチしない文字列
                TextContext context => new ResultText(context),
                // $1 ${1} など。Gropusの数字のみ
                Var_groupContext context => new ResultGroup(context),
                // $no ${no} ${rnd, 0} など
                VarContext context => new ResultVar(context),
                // エスケープされた $
                Escape_dollerContext context => new ResultEscapeDoller(context),
                // 単体の $
                Single_dollerContext context => new ResultSingleDoller(context),
                _ => throw new Exception("字句解析に失敗しました"),
            };
        }



        #region デバッグ確認用
        public static void ToString(IResultType[] results, int indent = 0)
        {
            foreach (var item in results) {
                ToString(item, indent);
            }
        }

        public static void ToString(IResultType item, int indent = 0)
        {
            var indentStr = Repeat("       ", indent);

            switch (item) {
                case ResultText text:
                    Console.WriteLine($"{indentStr}text : {text.Text}");
                    break;
                case ResultGroup group:
                    Console.WriteLine($"{indentStr}group: ${group.Group}");
                    break;
                case ResultVar var:
                    Console.WriteLine($"{indentStr}var  : ${var.Name}");
                    if (var.Args.Length > 0) {
                        var args = var.Args;
                        Console.WriteLine($"{indentStr}args :");
                        ToStringVars(args, indent + 1);
                    }
                    break;
                case ResultEscapeDoller _:
                    Console.WriteLine($"{indentStr}escap: $$");
                    break;
                case ResultSingleDoller _:
                    //var source = singleDoller.Context.SourceInterval;
                    Console.WriteLine($"{indentStr}doll : $");
                    break;
            }
        }

        public static void ToStringVars(IVarArg[] args, int indent)
        {
            var indentStr = Repeat("       ", indent);

            foreach (var item in args) {
                switch (item) {
                    case VarArgText text:
                        if (text.Warning)
                            Console.WriteLine($"{indentStr}error: {text.Text}");
                        else
                            Console.WriteLine($"{indentStr}text : {text.Text}");
                        break;
                    case VarArgGroup group:
                        Console.WriteLine($"{indentStr}group: ${group.Group}");
                        break;
                    case VarArgVar var:
                        ToString(var.Var, indent);
                        break;
                }
            }
        }

        // 文字列をnum回繰り返す
        static string Repeat(string str, int num) => new string('*', num).Replace("*", str);
        #endregion
    }
}
