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
            Args = var.arg()
                .Select(Convert)
                .ToArray();
        }

        public static IVarArg Convert(ArgContext args)
        {
            if (args.var_group() != null) {
                return new VarArgGroup(args);
            } else if (args.var() != null) {
                return new VarArgVar(args);
            }
            return new VarArgText(args);
        }
    }

    public interface IVarArg { }
    public class VarArgText : IVarArg
    {
        public ArgContext Context { get; }
        public string Text { get; }
        public VarArgText(ArgContext text)
        {
            Context = text;
            Text = text.GetText();
        }
    }

    public class VarArgGroup : IVarArg
    {
        public ArgContext Context { get; }
        public int Group { get; }
        public VarArgGroup(ArgContext group)
        {
            Context = group;
            Group = int.Parse(group.var_group().GROUP().GetText());
        }
    }

    public class VarArgVar : IVarArg
    {
        public ArgContext Context { get; }
        public ResultVar Var { get; }
        public VarArgVar(ArgContext var)
        {
            Context = var;
            Var = new ResultVar(var.var());
        }
    }
}
