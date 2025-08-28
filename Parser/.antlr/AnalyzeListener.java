// Generated from d:/Programing/1.lang-CSharp/Parser/Parser/Analyze.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AnalyzeParser}.
 */
public interface AnalyzeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AnalyzeParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(AnalyzeParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalyzeParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(AnalyzeParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalyzeParser#group}.
	 * @param ctx the parse tree
	 */
	void enterGroup(AnalyzeParser.GroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalyzeParser#group}.
	 * @param ctx the parse tree
	 */
	void exitGroup(AnalyzeParser.GroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalyzeParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(AnalyzeParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalyzeParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(AnalyzeParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalyzeParser#warn}.
	 * @param ctx the parse tree
	 */
	void enterWarn(AnalyzeParser.WarnContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalyzeParser#warn}.
	 * @param ctx the parse tree
	 */
	void exitWarn(AnalyzeParser.WarnContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalyzeParser#fn}.
	 * @param ctx the parse tree
	 */
	void enterFn(AnalyzeParser.FnContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalyzeParser#fn}.
	 * @param ctx the parse tree
	 */
	void exitFn(AnalyzeParser.FnContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalyzeParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(AnalyzeParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalyzeParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(AnalyzeParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalyzeParser#arg_text}.
	 * @param ctx the parse tree
	 */
	void enterArg_text(AnalyzeParser.Arg_textContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalyzeParser#arg_text}.
	 * @param ctx the parse tree
	 */
	void exitArg_text(AnalyzeParser.Arg_textContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalyzeParser#arg_warn}.
	 * @param ctx the parse tree
	 */
	void enterArg_warn(AnalyzeParser.Arg_warnContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalyzeParser#arg_warn}.
	 * @param ctx the parse tree
	 */
	void exitArg_warn(AnalyzeParser.Arg_warnContext ctx);
	/**
	 * Enter a parse tree produced by {@link AnalyzeParser#arg_empty}.
	 * @param ctx the parse tree
	 */
	void enterArg_empty(AnalyzeParser.Arg_emptyContext ctx);
	/**
	 * Exit a parse tree produced by {@link AnalyzeParser#arg_empty}.
	 * @param ctx the parse tree
	 */
	void exitArg_empty(AnalyzeParser.Arg_emptyContext ctx);
}