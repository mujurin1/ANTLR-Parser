using System.Linq;
using static Antlr4.AnalyzeParser;

namespace Parser
{
    public abstract class IResultType
    {
        /// <summary>
        /// 記述ミスの可能性があるか
        /// </summary>
        public bool Warning { get; protected set; } = false;
    }

    public class ResultEscapeDoller : IResultType
    {
        public Escape_dollerContext Context { get; }
        public ResultEscapeDoller(Escape_dollerContext context)
        {
            Context = context;
        }
    }
    public class ResultSingleDoller : IResultType
    {
        public Single_dollerContext Context { get; }
        public ResultSingleDoller(Single_dollerContext context)
        {
            Context = context;
        }
    }
    public class ResultText : IResultType
    {
        public TextContext Context { get; }
        public string Text { get; }
        public ResultText(TextContext context)
        {
            Context = context;
            Text = context.GetText();
        }
    }
    public class ResultGroup : IResultType
    {
        public Var_groupContext Context { get; }
        public int Group { get; }
        public ResultGroup(Var_groupContext context)
        {
            Context = context;
            Group = int.Parse(context.GROUP().GetText());
        }
    }

    public class ResultVar : IResultType
    {
        public VarContext Context { get; }
        public string Name { get; }
        public IVarArg[] Args { get; }
        public ResultVar(VarContext context)
        {
            Context = context;

            Name = context.NAME().GetText();
            Args = context.arg()
                .Select(Convert)
                .ToArray();
        }

        public static IVarArg Convert(ArgContext context)
        {
            if (context.var_group() != null) {
                return new VarArgGroup(context);
            } else if (context.var() != null) {
                return new VarArgVar(context);
            }
            return new VarArgText(context);
        }
    }



    public abstract class IVarArg : IResultType { }
    public class VarArgText : IVarArg
    {
        public ArgContext Context { get; }
        public string Text { get; }
        public VarArgText(ArgContext context)
        {
            Context = context;
            Text = context.GetText();
            Warning = context.arg_error() != null;
        }
    }
    public class VarArgGroup : IVarArg
    {
        public ArgContext Context { get; }
        public int Group { get; }
        public VarArgGroup(ArgContext context)
        {
            Context = context;
            Group = int.Parse(context.var_group().GROUP().GetText());
        }
    }
    public class VarArgVar : IVarArg
    {
        public ArgContext Context { get; }
        public ResultVar Var { get; }
        public VarArgVar(ArgContext context)
        {
            Context = context;
            Var = new ResultVar(context.var());
        }
    }
}
