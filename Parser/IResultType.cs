using System.Linq;
using static Antlr4.AnalyzeParser;

namespace Parser
{
    public interface IResultType { }

    public class ResultText : IResultType
    {
        public TextContext Context { get; }
        public string Text { get; }
        public ResultText(TextContext text)
        {
            Context = text;
            Text = text.GetText();
        }
    }

    public class ResultGroup : IResultType
    {
        public Var_groupContext Context { get; }
        public int Group { get; }
        public ResultGroup(Var_groupContext group)
        {
            Context = group;
            Group = int.Parse(group.GROUP().GetText());
        }
    }

    public class ResultVar : IResultType
    {
        public VarContext Context { get; }
        public string Name { get; }
        public IVarArg[] Args { get; }
        public ResultVar(VarContext var)
        {
            Context = var;

            Name = var.NAME().GetText();
            Args = var.args()
                .Select(Convert)
                .ToArray();
        }

        public static IVarArg Convert(ArgsContext args)
        {
            if (args.var_group() != null) {
                return new VarArgsGroup(args);
            } else if (args.var() != null) {
                return new VarArgsVar(args);
            }
            return new VarArgsText(args);
        }
    }

    public interface IVarArg { }
    public class VarArgsText : IVarArg
    {
        public ArgsContext Context { get; }
        public string Text { get; }
        public VarArgsText(ArgsContext text)
        {
            Context = text;
            Text = text.GetText();
        }
    }

    public class VarArgsGroup : IVarArg
    {
        public ArgsContext Context { get; }
        public ResultGroup Group { get; }
        public VarArgsGroup(ArgsContext group)
        {
            Context = group;
            Group = new ResultGroup(group.var_group());
        }
    }

    public class VarArgsVar : IVarArg
    {
        public ArgsContext Context { get; }
        public ResultVar Var { get; }
        public VarArgsVar(ArgsContext var)
        {
            Context = var;
            Var = new ResultVar(var.var());
        }
    }
}
