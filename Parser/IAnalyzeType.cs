using Antlr4.Runtime.Tree;
using System;
using System.Collections.Generic;
using System.Linq;
using static Antlr4.AnalyzeParser;

namespace Parser
{
    public abstract class IAnalyzeType
    {
        /// <summary>
        /// 記述ミスの可能性があるか
        /// </summary>
        public bool Warning { get; protected set; } = false;

        protected string EscapeText(IList<IParseTree> trees)
        {
            return string.Concat(trees.Select(EscapeLogic));
        }

        private static string EscapeLogic(IParseTree tree)
        {
            var token = (tree as TerminalNodeImpl).Payload;
            return token.Type is ESCAPED ? token.Text[1..] : token.Text;
        }
    }

    public class AnalyzeText : IAnalyzeType
    {
        public TextContext Context { get; }
        public string Text { get; }
        public AnalyzeText(TextContext context)
        {
            Context = context;
            Text = EscapeText(context.children);
        }
    }
    public class AnalyzeWarn : IAnalyzeType
    {
        public WarnContext Context { get; }
        public string Text { get; }
        public AnalyzeWarn(WarnContext context)
        {
            Context = context;
            Warning = true;
            // 必ず単体の文字なのでEscapeが含まれている可能性はない
            Text = context.GetText();
        }
    }
    public class AnalyzeGroup : IAnalyzeType
    {
        public GroupContext Context { get; }
        public int Group { get; }
        public AnalyzeGroup(GroupContext context)
        {
            Context = context;
            Group = int.Parse(context.GROUP().GetText());
        }
    }
    public class AnalyzeFn : IAnalyzeType
    {
        public FnContext Context { get; }
        /** 必ず大文字 */
        public string Name { get; }
        public IFnArg[] Args { get; }
        public AnalyzeFn(FnContext context)
        {
            Context = context;

            Name = context.NAME().GetText().ToUpper();
            Args = context.arg()
                .Select(Convert)
                .ToArray();
        }

        public static IFnArg Convert(ArgContext context)
        {
            return context switch {
                _ when context.group() is GroupContext _context => new FnArgGroup(_context),
                _ when context.fn() is FnContext _context => new FnArgFn(_context),
                _ when context.arg_text() is Arg_textContext _context => new FnArgText(_context),
                _ when context.arg_warn() is Arg_warnContext _context => new FnArgWarn(_context),
                _ => throw new Exception("字句解析に失敗しました"),
            };

        }
    }



    public abstract class IFnArg : IAnalyzeType { }
    public class FnArgText : IFnArg
    {
        public Arg_textContext Context { get; }
        public string Text { get; }
        public FnArgText(Arg_textContext context)
        {
            Context = context;
            Text = EscapeText(context.children);
        }
    }
    public class FnArgWarn : IFnArg
    {
        public Arg_warnContext Context { get; }
        public string Text { get; }
        public FnArgWarn(Arg_warnContext context)
        {
            Context = context;
            Warning = true;
            Text = context.arg_empty() != null ? "" : EscapeText(context.children);
        }
    }
    public class FnArgGroup : IFnArg
    {
        public GroupContext Context { get; }
        public int Group { get; }
        public FnArgGroup(GroupContext context)
        {
            Context = context;
            Group = int.Parse(context.GROUP().GetText());
        }
    }
    public class FnArgFn : IFnArg
    {
        public FnContext Context { get; }
        public AnalyzeFn Fn { get; }
        public FnArgFn(FnContext context)
        {
            Context = context;
            Fn = new AnalyzeFn(context);
        }
    }
}
