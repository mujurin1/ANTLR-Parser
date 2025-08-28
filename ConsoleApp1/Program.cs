using Parser;
using System.Text;
using System.Text.RegularExpressions;

namespace ConsoleApp1;

class Program
{
    public static void Main()
    {
        var res = Replacer.Replace(@"${vVa,$0,$\\-,\\aa\,\\\$,\,,\\,,,,\}}");
        Console.WriteLine(Replacer.ToString(res));
        Console.WriteLine();

        foreach (var (input, regex, replace) in new (string, string, string)[] {
            (
                "1d100",
                "1d([1-9][0-9]*)",
                "${DICE, $1}"
            ), (
                "YESおみくじ",
                "おみくじ",
                "${OMIKUJI}"
            ), (
                // 複数マッチする場合は最初の１つだけマッチする
                "1d1000   1d2",
                "1d([1-9][0-9]*)",
                "${DICE, $1}"
            ), (
                // グループ番号が一致しない (その部分は "" が返る. エラーにはならない)
                "1d1000",
                "1d([1-9][0-9]*)",
                "${DICE, $10}"
            ), (
                // Replace が変な場合の例
                "1d1   1d1000",
                "1d([1-9][0-9]*)",
                "$-a{}\\$a$DICE___${DICE, a}"
            ),
        }) {
            var result = Replace(input, regex, replace);
            Console.WriteLine(result);
        }
    }

    public static string Replace(string input, string regex, string replace)
    {
        var match = Regex.Match(input, regex);
        if (!match.Success) return input;

        var res = Replacer.Replace(replace);

        var sb = new StringBuilder();
        foreach (var item in res) {
            sb.Append(
                item switch {
                    AnalyzeGroup group => match.Groups[group.Group].Value,
                    AnalyzeFn var => Fns(var, match),
                    AnalyzeText text => text.Text,
                    AnalyzeWarn warn => warn.Text,
                    _ => throw new Exception(),
                }
            );
        }

        return sb.ToString();
    }

    public static string ResutToText(IAnalyzeType item, Match match)
    {
        return item switch {
            AnalyzeText text => text.Text,
            AnalyzeGroup group => match.Groups[group.Group].Value,
            AnalyzeFn var => Fns(var, match),
            _ => throw new Exception(),
        };
    }



    private static Random rnd = new();
    public static string Fns(AnalyzeFn var, Match match)
    {
        return var.Name switch {
            "NO" => "[行番号]",
            "NAME" => "[名前]",
            "DICE" => Dice(var, match),
            "OMIKUJI" => "[おみくじ]",
            _ => var.Context.GetText(),
        };
    }

    private static string Dice(AnalyzeFn var, Match match)
    {
        if (var.Args.Length >= 1 &&
            ArgToText(var.Args[0], match) is var text &&
            int.TryParse(text, out int num)
        )
            return (rnd.Next(num) + 1).ToString();

        return var.Context.GetText();
    }

    public static string ArgToText(IFnArg arg, Match match)
    {
        return arg switch {
            FnArgGroup group => match.Groups[group.Group].Value,
            FnArgFn var => ResutToText(var.Fn, match),
            FnArgText text => text.Text,
            FnArgWarn warn => warn.Text,
            _ => throw new Exception(),
        };
    }
}