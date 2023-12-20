using Parser;
using System;
using System.Text;
using System.Text.RegularExpressions;

/*
 * Parser は DLL なのでテスト用のプロジェクト
 * このプロジェクト (ConsoleApp1) は Parser を参照している
 */

class Program
{
    public static void Main()
    {
        var res = Replacer.Replace("aa$1$aaa${ repeat,  10, a,  ${rnd,$1,1}  }");
        Replacer.ToString(res);

        Console.WriteLine();

        var res1 = Replace(
            "10?:1d10   100?:1d100",
            "1d([0-9]*)",
            "${rnd, $1}"
        );
        Console.WriteLine(res1);

        var res2 = Replace(
            "わこつ",
            ".*わこつ.*",
            ">>$no $name さんいらっしゃい！$omikujiをあげるね！"
        );
        Console.WriteLine(res2);
    }

    public static string Replace(string target, string regex, string replace)
    {
        return Regex.Replace(
            target,
            regex,
            (match) => {
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
                    }
                }

                return sb.ToString();
            }
        );
    }

    public static string ResutToText(IResultType item, Match match)
    {
        switch (item) {
            case ResultText text:
                return text.Text;
            case ResultGroup group:
                return match.Groups[group.Group].Value;
            case ResultVar var:
                return Vars(var, match);
        }

        throw new Exception();
    }



    private static Random rnd = new Random();
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
        switch (arg) {
            case VarArgsText text:
                return text.Text;
            case VarArgsGroup group:
                return match.Groups[group.Group.Group].Value;
            case VarArgsVar var:
                return ResutToText(var.Var, match);
        }

        throw new Exception();
    }
}