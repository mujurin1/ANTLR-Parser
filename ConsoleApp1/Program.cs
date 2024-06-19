using Parser;
using System.Text;
using System.Text.RegularExpressions;

namespace ConsoleApp1;

class Program
{
    public static void Main()
    {
        var res = Replacer.Replace("$acd$1$$$-$$1$$$aaa$-${ repeat,  $10, 1,  ${rnd,a$,as$$d}  }おわり$$");
        Replacer.ToString(res);

        Console.WriteLine();

        foreach (var item in new (string, string, string)[] {
            (
                "1d1   1d1000",
                "1d([1-9][0-9]*)",
                "${rnd, $1}"
            ), (
                "1d1   1d1000",
                "1d([1-9][0-9]*)",
                "${rnd, $1}"
            ), (
                "1d1   1d1000",
                "1d([1-9][0-9]*)",
                "$-a{}$$a$rnd${rnd, $$}"
            ),
        }) {
            var result = Replace(item.Item1, item.Item2, item.Item3);
            Console.WriteLine(result);
        }
    }

    public static string Replace(string target, string regex, string replace)
    {
        var match = Regex.Match(target, regex);

        if (!match.Success) return target;

        var res = Replacer.Replace(replace);

        var sb = new StringBuilder();
        foreach (var item in res) {
            switch (item) {
                case ResultText text:
                    sb.Append(text.Text);
                    break;
                case ResultGroup group:
                    sb.Append(match.Groups[group.Group].Value);
                    break;
                case ResultVar var:
                    sb.Append(Vars(var, match));
                    break;
                case ResultEscapeDoller or ResultSingleDoller _:
                    sb.Append('$');
                    break;
            }
        }

        return sb.ToString();
    }

    public static string ResutToText(IResultType item, Match match)
    {
        return item switch {
            ResultText text => text.Text,
            ResultGroup group => match.Groups[group.Group].Value,
            ResultVar var => Vars(var, match),
            _ => throw new Exception(),
        };
    }



    private static Random rnd = new();
    public static string Vars(ResultVar var, Match match)
    {
        if (var.Name == "no") {
            return "[行番号]";
        } else if (var.Name == "name") {
            return "[名前]";
        } else if (var.Name == "rnd") {
            if (var.Args.Length < 1) goto END;
            var text = ArgToText(var.Args[0], match);
            if (!int.TryParse(text, out int num)) goto END;

            return rnd.Next(num).ToString();
        } else if (var.Name == "omikuji") {
            return "[おみくじ]";
        }
    // どれにも一致しない場合は元々の文字をそのまま返す
    END: return var.Context.GetText();
    }

    public static string ArgToText(IVarArg arg, Match match)
    {
        return arg switch {
            VarArgText text => text.Text,
            VarArgGroup group => match.Groups[group.Group].Value,
            VarArgVar var => ResutToText(var.Var, match),
            _ => throw new Exception(),
        };
    }
}