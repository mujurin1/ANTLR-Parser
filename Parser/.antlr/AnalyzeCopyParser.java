// Generated from d:/Programing/1.lang-CSharp/Parser/Parser/AnalyzeCopy.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AnalyzeCopyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, GROUP=5, NAME=6, WS=7, ANY=8;
	public static final int
		RULE_parse = 0, RULE_var = 1, RULE_var_group = 2, RULE_arg = 3, RULE_var_text = 4, 
		RULE_arg_error = 5, RULE_text = 6, RULE_escape_doller = 7, RULE_single_doller = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "var", "var_group", "arg", "var_text", "arg_error", "text", 
			"escape_doller", "single_doller"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'$'", "'{'", "','", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "GROUP", "NAME", "WS", "ANY"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "AnalyzeCopy.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AnalyzeCopyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParseContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<Var_groupContext> var_group() {
			return getRuleContexts(Var_groupContext.class);
		}
		public Var_groupContext var_group(int i) {
			return getRuleContext(Var_groupContext.class,i);
		}
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public List<Escape_dollerContext> escape_doller() {
			return getRuleContexts(Escape_dollerContext.class);
		}
		public Escape_dollerContext escape_doller(int i) {
			return getRuleContext(Escape_dollerContext.class,i);
		}
		public List<Single_dollerContext> single_doller() {
			return getRuleContexts(Single_dollerContext.class);
		}
		public Single_dollerContext single_doller(int i) {
			return getRuleContext(Single_dollerContext.class,i);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 510L) != 0)) {
				{
				setState(25);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(18);
					var();
					}
					break;
				case 2:
					{
					setState(19);
					var_group();
					}
					break;
				case 3:
					{
					setState(23);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(20);
						text();
						}
						break;
					case 2:
						{
						setState(21);
						escape_doller();
						}
						break;
					case 3:
						{
						setState(22);
						single_doller();
						}
						break;
					}
					}
					break;
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(AnalyzeCopyParser.NAME, 0); }
		public List<TerminalNode> WS() { return getTokens(AnalyzeCopyParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AnalyzeCopyParser.WS, i);
		}
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_var);
		int _la;
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				match(T__0);
				setState(31);
				match(NAME);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				match(T__0);
				setState(33);
				match(T__1);
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(34);
					match(WS);
					}
				}

				setState(37);
				match(NAME);
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(38);
					match(WS);
					}
				}

				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(41);
					match(T__2);
					setState(43);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						setState(42);
						match(WS);
						}
						break;
					}
					setState(45);
					arg();
					setState(47);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==WS) {
						{
						setState(46);
						match(WS);
						}
					}

					}
					}
					setState(53);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(54);
				match(T__3);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Var_groupContext extends ParserRuleContext {
		public TerminalNode GROUP() { return getToken(AnalyzeCopyParser.GROUP, 0); }
		public List<TerminalNode> WS() { return getTokens(AnalyzeCopyParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AnalyzeCopyParser.WS, i);
		}
		public Var_groupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_group; }
	}

	public final Var_groupContext var_group() throws RecognitionException {
		Var_groupContext _localctx = new Var_groupContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_group);
		int _la;
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				match(T__0);
				setState(58);
				match(GROUP);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				match(T__0);
				setState(60);
				match(T__1);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(61);
					match(WS);
					}
				}

				setState(64);
				match(GROUP);
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(65);
					match(WS);
					}
				}

				setState(68);
				match(T__3);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public Var_groupContext var_group() {
			return getRuleContext(Var_groupContext.class,0);
		}
		public Var_textContext var_text() {
			return getRuleContext(Var_textContext.class,0);
		}
		public Arg_errorContext arg_error() {
			return getRuleContext(Arg_errorContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_arg);
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				var();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				var_group();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				var_text();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				arg_error();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Var_textContext extends ParserRuleContext {
		public Var_textContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_text; }
	}

	public final Var_textContext var_text() throws RecognitionException {
		Var_textContext _localctx = new Var_textContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_var_text);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(80); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(80);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__0:
						{
						setState(77);
						match(T__0);
						setState(78);
						match(T__0);
						}
						break;
					case T__1:
					case GROUP:
					case NAME:
					case WS:
					case ANY:
						{
						setState(79);
						_la = _input.LA(1);
						if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & 26L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(82); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Arg_errorContext extends ParserRuleContext {
		public Arg_errorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_error; }
	}

	public final Arg_errorContext arg_error() throws RecognitionException {
		Arg_errorContext _localctx = new Arg_errorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arg_error);
		int _la;
		try {
			int _alt;
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(85);
						_la = _input.LA(1);
						if ( _la <= 0 || (_la==T__2 || _la==T__3) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(88); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TextContext extends ParserRuleContext {
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_text);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(93); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(92);
					_la = _input.LA(1);
					if ( _la <= 0 || (_la==T__0) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(95); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Escape_dollerContext extends ParserRuleContext {
		public Escape_dollerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escape_doller; }
	}

	public final Escape_dollerContext escape_doller() throws RecognitionException {
		Escape_dollerContext _localctx = new Escape_dollerContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_escape_doller);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__0);
			setState(98);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Single_dollerContext extends ParserRuleContext {
		public Single_dollerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_doller; }
	}

	public final Single_dollerContext single_doller() throws RecognitionException {
		Single_dollerContext _localctx = new Single_dollerContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_single_doller);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\bg\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0003\u0000\u0018\b\u0000\u0005\u0000\u001a\b\u0000\n\u0000\f\u0000\u001d"+
		"\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001$\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001(\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001,\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"0\b\u0001\u0005\u00012\b\u0001\n\u0001\f\u00015\t\u0001\u0001\u0001\u0003"+
		"\u00018\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002?\b\u0002\u0001\u0002\u0001\u0002\u0003\u0002C\b\u0002"+
		"\u0001\u0002\u0003\u0002F\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003L\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0004\u0004Q\b\u0004\u000b\u0004\f\u0004R\u0001\u0005\u0001\u0005\u0004"+
		"\u0005W\b\u0005\u000b\u0005\f\u0005X\u0003\u0005[\b\u0005\u0001\u0006"+
		"\u0004\u0006^\b\u0006\u000b\u0006\f\u0006_\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0000\u0000\t\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0000\u0003\u0002\u0000\u0001\u0001\u0003\u0004\u0001"+
		"\u0000\u0003\u0004\u0001\u0000\u0001\u0001s\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u00027\u0001\u0000\u0000\u0000\u0004E\u0001\u0000\u0000\u0000\u0006"+
		"K\u0001\u0000\u0000\u0000\bP\u0001\u0000\u0000\u0000\nZ\u0001\u0000\u0000"+
		"\u0000\f]\u0001\u0000\u0000\u0000\u000ea\u0001\u0000\u0000\u0000\u0010"+
		"d\u0001\u0000\u0000\u0000\u0012\u001a\u0003\u0002\u0001\u0000\u0013\u001a"+
		"\u0003\u0004\u0002\u0000\u0014\u0018\u0003\f\u0006\u0000\u0015\u0018\u0003"+
		"\u000e\u0007\u0000\u0016\u0018\u0003\u0010\b\u0000\u0017\u0014\u0001\u0000"+
		"\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0017\u0016\u0001\u0000"+
		"\u0000\u0000\u0018\u001a\u0001\u0000\u0000\u0000\u0019\u0012\u0001\u0000"+
		"\u0000\u0000\u0019\u0013\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000"+
		"\u0000\u0000\u001a\u001d\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000"+
		"\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u0001\u0001\u0000"+
		"\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001e\u001f\u0005\u0001"+
		"\u0000\u0000\u001f8\u0005\u0006\u0000\u0000 !\u0005\u0001\u0000\u0000"+
		"!#\u0005\u0002\u0000\u0000\"$\u0005\u0007\u0000\u0000#\"\u0001\u0000\u0000"+
		"\u0000#$\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%\'\u0005\u0006"+
		"\u0000\u0000&(\u0005\u0007\u0000\u0000\'&\u0001\u0000\u0000\u0000\'(\u0001"+
		"\u0000\u0000\u0000(3\u0001\u0000\u0000\u0000)+\u0005\u0003\u0000\u0000"+
		"*,\u0005\u0007\u0000\u0000+*\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000"+
		"\u0000,-\u0001\u0000\u0000\u0000-/\u0003\u0006\u0003\u0000.0\u0005\u0007"+
		"\u0000\u0000/.\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u000002\u0001"+
		"\u0000\u0000\u00001)\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u0000"+
		"31\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000046\u0001\u0000\u0000"+
		"\u000053\u0001\u0000\u0000\u000068\u0005\u0004\u0000\u00007\u001e\u0001"+
		"\u0000\u0000\u00007 \u0001\u0000\u0000\u00008\u0003\u0001\u0000\u0000"+
		"\u00009:\u0005\u0001\u0000\u0000:F\u0005\u0005\u0000\u0000;<\u0005\u0001"+
		"\u0000\u0000<>\u0005\u0002\u0000\u0000=?\u0005\u0007\u0000\u0000>=\u0001"+
		"\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000"+
		"@B\u0005\u0005\u0000\u0000AC\u0005\u0007\u0000\u0000BA\u0001\u0000\u0000"+
		"\u0000BC\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DF\u0005\u0004"+
		"\u0000\u0000E9\u0001\u0000\u0000\u0000E;\u0001\u0000\u0000\u0000F\u0005"+
		"\u0001\u0000\u0000\u0000GL\u0003\u0002\u0001\u0000HL\u0003\u0004\u0002"+
		"\u0000IL\u0003\b\u0004\u0000JL\u0003\n\u0005\u0000KG\u0001\u0000\u0000"+
		"\u0000KH\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KJ\u0001\u0000"+
		"\u0000\u0000L\u0007\u0001\u0000\u0000\u0000MN\u0005\u0001\u0000\u0000"+
		"NQ\u0005\u0001\u0000\u0000OQ\b\u0000\u0000\u0000PM\u0001\u0000\u0000\u0000"+
		"PO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000"+
		"\u0000RS\u0001\u0000\u0000\u0000S\t\u0001\u0000\u0000\u0000T[\u0001\u0000"+
		"\u0000\u0000UW\b\u0001\u0000\u0000VU\u0001\u0000\u0000\u0000WX\u0001\u0000"+
		"\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000Y[\u0001"+
		"\u0000\u0000\u0000ZT\u0001\u0000\u0000\u0000ZV\u0001\u0000\u0000\u0000"+
		"[\u000b\u0001\u0000\u0000\u0000\\^\b\u0002\u0000\u0000]\\\u0001\u0000"+
		"\u0000\u0000^_\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001"+
		"\u0000\u0000\u0000`\r\u0001\u0000\u0000\u0000ab\u0005\u0001\u0000\u0000"+
		"bc\u0005\u0001\u0000\u0000c\u000f\u0001\u0000\u0000\u0000de\u0005\u0001"+
		"\u0000\u0000e\u0011\u0001\u0000\u0000\u0000\u0012\u0017\u0019\u001b#\'"+
		"+/37>BEKPRXZ_";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}