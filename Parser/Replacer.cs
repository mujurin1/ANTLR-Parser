using Antlr4;
using Antlr4.Runtime;
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

        public static IResultType Convert(Antlr4.Runtime.Tree.IParseTree tree)
        {
            switch (tree) {
                // どれにもマッチしない文字列
                case TextContext text:
                    return new ResultText(text);
                // $1 ${1} など。Gropusの数字のみ
                case Var_groupContext gruop:
                    return new ResultGroup(gruop);
                // $no ${no} ${rnd, 0} など
                case VarContext context:
                    return new ResultVar(context);
            }

            throw new Exception("字句解析に失敗しました");
        }

        // デバッグ確認用
        public static void ToString(IResultType[] results, int indent = 0)
        {
            foreach (var item in results) {
                ToString(item, indent);
            }
        }

        public static void ToString(IResultType item, int indent = 0)
        {
            var indentStr = Repeat("      ", indent);

            switch (item) {
                case ResultText text:
                    Console.WriteLine($"{indentStr}text : {text.Text}");
                    break;
                case ResultGroup group:
                    Console.WriteLine($"{indentStr}group: ${group.Group}");
                    break;
                case ResultVar var:
                    Console.WriteLine($"{indentStr}var  : {var.Name}");

                    if (var.Args.Length > 0) {
                        var args = var.Args;
                        Console.WriteLine($"{indentStr}var_args:");
                        ToStringVars(args, indent + 1);
                    }

                    break;
            }
        }

        public static void ToStringVars(IVarArg[] args, int indent)
        {
            var indentStr = Repeat("      ", indent);

            foreach (var item in args) {
                switch (item) {
                    case VarArgText text:
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
    }
}
