using Antlr4;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using System;
using System.Linq;
using System.Text;
using static Antlr4.AnalyzeParser;

/*
 * プログラムで利用する g4 ファイルは csproj に定義する必要がある
 * 
 * 必要なする nuget パッケージは２つ
 *  * Antlr4.Runtime.Standard
 *  * Antlr4BuildTasks
 */

namespace Parser
{
    public static partial class Replacer
    {
        public static IAnalyzeType[] Replace(string str)
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

        public static string ReplaceAndToString(string str)
        {
            var inputStream = new AntlrInputStream(str);
            var lexer = new AnalyzeLexer(inputStream);
            var commonTokenStream = new CommonTokenStream(lexer);
            var parser = new AnalyzeParser(commonTokenStream);
            var visitor = new AnalyzeBaseVisitor<string>();
            var graphContext = parser.parse();

            var types = graphContext.children
                .Select(Convert)
                .ToArray();

            return ToString(types);
        }

        private static IAnalyzeType Convert(IParseTree tree)
        {
            return tree switch {
                // $1 ${1} など。Gropusの数字のみ
                GroupContext context => new AnalyzeGroup(context),
                // $no ${no} ${rnd, 0} など
                FnContext context => new AnalyzeFn(context),
                // 文字列
                TextContext context => new AnalyzeText(context),
                // 警告を出す必要がある文字列
                WarnContext context => new AnalyzeWarn(context),
                _ => throw new Exception("字句解析に失敗しました"),
            };
        }



        #region デバッグ確認用
        public static string ToString(IAnalyzeType[] results, int indent = 0)
        {
            var sb = new StringBuilder();
            foreach (var item in results) {
                _ToString(item, indent, sb);
            }
            return sb.ToString();
        }

        private static void _ToString(IAnalyzeType item, int indent, StringBuilder sb)
        {
            var indentStr = Repeat("       ", indent);

            switch (item) {
                case AnalyzeGroup group:
                    sb.AppendLine($"{indentStr}group: {group.Group}");
                    break;
                case AnalyzeFn fn:
                    sb.AppendLine($"{indentStr}fn   : {fn.Name}");
                    if (fn.Args.Length > 0) {
                        var args = fn.Args;
                        sb.AppendLine($"{indentStr}args :");
                        ToStringFns(args, indent + 1, sb);
                    }
                    break;
                case AnalyzeText text:
                    sb.AppendLine($"{indentStr}text : {text.Text}");
                    break;
                case AnalyzeWarn textWarn:
                    sb.AppendLine($"{indentStr}warn : {textWarn.Text}");
                    break;
                default:
                    throw new Exception();
            }
        }

        public static void ToStringFns(IFnArg[] args, int indent, StringBuilder sb)
        {
            var indentStr = Repeat("       ", indent);

            foreach (var item in args) {
                switch (item) {
                    case FnArgGroup group:
                        sb.AppendLine($"{indentStr}group: {group.Group}");
                        break;
                    case FnArgFn fn:
                        _ToString(fn.Fn, indent, sb);
                        break;
                    case FnArgText text:
                        sb.AppendLine($"{indentStr}text : {text.Text}");
                        break;
                    case FnArgWarn warn:
                        sb.AppendLine($"{indentStr}warn : {warn.Text}");
                        break;
                    default:
                        throw new Exception();
                }
            }
        }

        // 文字列をnum回繰り返す
        private static string Repeat(string str, int num) => new string('*', num).Replace("*", str);
        #endregion
    }
}
