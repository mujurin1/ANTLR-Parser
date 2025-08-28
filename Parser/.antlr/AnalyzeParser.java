// Generated from d:/Programing/1.lang-CSharp/Parser/Parser/Analyze.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AnalyzeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, GROUP=2, NAME=3, WS=4, ESCAPED=5, ESCAPE=6, DOLLAR=7, COMMA=8, 
		CLOSE=9, ANY=10;
	public static final int
		RULE_parse = 0, RULE_group = 1, RULE_text = 2, RULE_warn = 3, RULE_empty = 4, 
		RULE_fn = 5, RULE_arg = 6, RULE_arg_text = 7, RULE_arg_warn = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "group", "text", "warn", "empty", "fn", "arg", "arg_text", "arg_warn"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", null, null, null, null, "'\\'", "'$'", "','", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "GROUP", "NAME", "WS", "ESCAPED", "ESCAPE", "DOLLAR", "COMMA", 
			"CLOSE", "ANY"
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
	public String getGrammarFileName() { return "Analyze.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AnalyzeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParseContext extends ParserRuleContext {
		public List<FnContext> fn() {
			return getRuleContexts(FnContext.class);
		}
		public FnContext fn(int i) {
			return getRuleContext(FnContext.class,i);
		}
		public List<GroupContext> group() {
			return getRuleContexts(GroupContext.class);
		}
		public GroupContext group(int i) {
			return getRuleContext(GroupContext.class,i);
		}
		public List<WarnContext> warn() {
			return getRuleContexts(WarnContext.class);
		}
		public WarnContext warn(int i) {
			return getRuleContext(WarnContext.class,i);
		}
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
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
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2046L) != 0)) {
				{
				setState(24);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(18);
					fn();
					}
					break;
				case 2:
					{
					setState(19);
					group();
					}
					break;
				case 3:
					{
					setState(22);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ESCAPE:
					case DOLLAR:
					case COMMA:
					case CLOSE:
						{
						setState(20);
						warn();
						}
						break;
					case T__0:
					case GROUP:
					case NAME:
					case WS:
					case ESCAPED:
					case ANY:
						{
						setState(21);
						text();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				}
				}
				setState(28);
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
	public static class GroupContext extends ParserRuleContext {
		public TerminalNode DOLLAR() { return getToken(AnalyzeParser.DOLLAR, 0); }
		public TerminalNode GROUP() { return getToken(AnalyzeParser.GROUP, 0); }
		public TerminalNode CLOSE() { return getToken(AnalyzeParser.CLOSE, 0); }
		public List<TerminalNode> WS() { return getTokens(AnalyzeParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AnalyzeParser.WS, i);
		}
		public GroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group; }
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_group);
		int _la;
		try {
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				match(DOLLAR);
				setState(30);
				match(GROUP);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				match(DOLLAR);
				setState(32);
				match(T__0);
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(33);
					match(WS);
					}
				}

				setState(36);
				match(GROUP);
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(37);
					match(WS);
					}
				}

				setState(40);
				match(CLOSE);
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
		public List<TerminalNode> ESCAPE() { return getTokens(AnalyzeParser.ESCAPE); }
		public TerminalNode ESCAPE(int i) {
			return getToken(AnalyzeParser.ESCAPE, i);
		}
		public List<TerminalNode> DOLLAR() { return getTokens(AnalyzeParser.DOLLAR); }
		public TerminalNode DOLLAR(int i) {
			return getToken(AnalyzeParser.DOLLAR, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AnalyzeParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AnalyzeParser.COMMA, i);
		}
		public List<TerminalNode> CLOSE() { return getTokens(AnalyzeParser.CLOSE); }
		public TerminalNode CLOSE(int i) {
			return getToken(AnalyzeParser.CLOSE, i);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_text);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(44); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(43);
					_la = _input.LA(1);
					if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & 960L) != 0)) ) {
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
				setState(46); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
	public static class WarnContext extends ParserRuleContext {
		public TerminalNode ESCAPE() { return getToken(AnalyzeParser.ESCAPE, 0); }
		public TerminalNode DOLLAR() { return getToken(AnalyzeParser.DOLLAR, 0); }
		public TerminalNode COMMA() { return getToken(AnalyzeParser.COMMA, 0); }
		public TerminalNode CLOSE() { return getToken(AnalyzeParser.CLOSE, 0); }
		public WarnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_warn; }
	}

	public final WarnContext warn() throws RecognitionException {
		WarnContext _localctx = new WarnContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_warn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 960L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class EmptyContext extends ParserRuleContext {
		public EmptyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_empty; }
	}

	public final EmptyContext empty() throws RecognitionException {
		EmptyContext _localctx = new EmptyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_empty);
		try {
			enterOuterAlt(_localctx, 1);
			{
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
	public static class FnContext extends ParserRuleContext {
		public TerminalNode DOLLAR() { return getToken(AnalyzeParser.DOLLAR, 0); }
		public TerminalNode NAME() { return getToken(AnalyzeParser.NAME, 0); }
		public TerminalNode CLOSE() { return getToken(AnalyzeParser.CLOSE, 0); }
		public List<TerminalNode> WS() { return getTokens(AnalyzeParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(AnalyzeParser.WS, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AnalyzeParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AnalyzeParser.COMMA, i);
		}
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public FnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fn; }
	}

	public final FnContext fn() throws RecognitionException {
		FnContext _localctx = new FnContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fn);
		int _la;
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(DOLLAR);
				setState(53);
				match(NAME);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(DOLLAR);
				setState(55);
				match(T__0);
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(56);
					match(WS);
					}
				}

				setState(59);
				match(NAME);
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(60);
					match(WS);
					}
				}

				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(63);
					match(COMMA);
					setState(65);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						setState(64);
						match(WS);
						}
						break;
					}
					setState(67);
					arg();
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==WS) {
						{
						setState(68);
						match(WS);
						}
					}

					}
					}
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(76);
				match(CLOSE);
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
		public FnContext fn() {
			return getRuleContext(FnContext.class,0);
		}
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public Arg_textContext arg_text() {
			return getRuleContext(Arg_textContext.class,0);
		}
		public Arg_warnContext arg_warn() {
			return getRuleContext(Arg_warnContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_arg);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				fn();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				group();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				arg_text();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(82);
				arg_warn();
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
	public static class Arg_textContext extends ParserRuleContext {
		public List<TerminalNode> DOLLAR() { return getTokens(AnalyzeParser.DOLLAR); }
		public TerminalNode DOLLAR(int i) {
			return getToken(AnalyzeParser.DOLLAR, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AnalyzeParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AnalyzeParser.COMMA, i);
		}
		public List<TerminalNode> ESCAPE() { return getTokens(AnalyzeParser.ESCAPE); }
		public TerminalNode ESCAPE(int i) {
			return getToken(AnalyzeParser.ESCAPE, i);
		}
		public List<TerminalNode> CLOSE() { return getTokens(AnalyzeParser.CLOSE); }
		public TerminalNode CLOSE(int i) {
			return getToken(AnalyzeParser.CLOSE, i);
		}
		public Arg_textContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_text; }
	}

	public final Arg_textContext arg_text() throws RecognitionException {
		Arg_textContext _localctx = new Arg_textContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arg_text);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
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
					if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & 960L) != 0)) ) {
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
	public static class Arg_warnContext extends ParserRuleContext {
		public EmptyContext empty() {
			return getRuleContext(EmptyContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(AnalyzeParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AnalyzeParser.COMMA, i);
		}
		public Arg_warnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_warn; }
	}

	public final Arg_warnContext arg_warn() throws RecognitionException {
		Arg_warnContext _localctx = new Arg_warnContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arg_warn);
		int _la;
		try {
			int _alt;
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				empty();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(92); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(91);
						_la = _input.LA(1);
						if ( _la <= 0 || (_la==COMMA) ) {
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
					setState(94); 
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

	public static final String _serializedATN =
		"\u0004\u0001\nc\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000"+
		"\u0017\b\u0000\u0005\u0000\u0019\b\u0000\n\u0000\f\u0000\u001c\t\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"#\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001\'\b\u0001\u0001\u0001\u0003"+
		"\u0001*\b\u0001\u0001\u0002\u0004\u0002-\b\u0002\u000b\u0002\f\u0002."+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005:\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005>\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"B\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005F\b\u0005\u0005\u0005H\b"+
		"\u0005\n\u0005\f\u0005K\t\u0005\u0001\u0005\u0003\u0005N\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006T\b\u0006\u0001"+
		"\u0007\u0004\u0007W\b\u0007\u000b\u0007\f\u0007X\u0001\b\u0001\b\u0004"+
		"\b]\b\b\u000b\b\f\b^\u0003\ba\b\b\u0001\b\u0000\u0000\t\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0000\u0002\u0001\u0000\u0006\t\u0001\u0000\b"+
		"\bm\u0000\u001a\u0001\u0000\u0000\u0000\u0002)\u0001\u0000\u0000\u0000"+
		"\u0004,\u0001\u0000\u0000\u0000\u00060\u0001\u0000\u0000\u0000\b2\u0001"+
		"\u0000\u0000\u0000\nM\u0001\u0000\u0000\u0000\fS\u0001\u0000\u0000\u0000"+
		"\u000eV\u0001\u0000\u0000\u0000\u0010`\u0001\u0000\u0000\u0000\u0012\u0019"+
		"\u0003\n\u0005\u0000\u0013\u0019\u0003\u0002\u0001\u0000\u0014\u0017\u0003"+
		"\u0006\u0003\u0000\u0015\u0017\u0003\u0004\u0002\u0000\u0016\u0014\u0001"+
		"\u0000\u0000\u0000\u0016\u0015\u0001\u0000\u0000\u0000\u0017\u0019\u0001"+
		"\u0000\u0000\u0000\u0018\u0012\u0001\u0000\u0000\u0000\u0018\u0013\u0001"+
		"\u0000\u0000\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0019\u001c\u0001"+
		"\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a\u001b\u0001"+
		"\u0000\u0000\u0000\u001b\u0001\u0001\u0000\u0000\u0000\u001c\u001a\u0001"+
		"\u0000\u0000\u0000\u001d\u001e\u0005\u0007\u0000\u0000\u001e*\u0005\u0002"+
		"\u0000\u0000\u001f \u0005\u0007\u0000\u0000 \"\u0005\u0001\u0000\u0000"+
		"!#\u0005\u0004\u0000\u0000\"!\u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000"+
		"\u0000#$\u0001\u0000\u0000\u0000$&\u0005\u0002\u0000\u0000%\'\u0005\u0004"+
		"\u0000\u0000&%\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'(\u0001"+
		"\u0000\u0000\u0000(*\u0005\t\u0000\u0000)\u001d\u0001\u0000\u0000\u0000"+
		")\u001f\u0001\u0000\u0000\u0000*\u0003\u0001\u0000\u0000\u0000+-\b\u0000"+
		"\u0000\u0000,+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.,\u0001"+
		"\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/\u0005\u0001\u0000\u0000"+
		"\u000001\u0007\u0000\u0000\u00001\u0007\u0001\u0000\u0000\u000023\u0001"+
		"\u0000\u0000\u00003\t\u0001\u0000\u0000\u000045\u0005\u0007\u0000\u0000"+
		"5N\u0005\u0003\u0000\u000067\u0005\u0007\u0000\u000079\u0005\u0001\u0000"+
		"\u00008:\u0005\u0004\u0000\u000098\u0001\u0000\u0000\u00009:\u0001\u0000"+
		"\u0000\u0000:;\u0001\u0000\u0000\u0000;=\u0005\u0003\u0000\u0000<>\u0005"+
		"\u0004\u0000\u0000=<\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000"+
		">I\u0001\u0000\u0000\u0000?A\u0005\b\u0000\u0000@B\u0005\u0004\u0000\u0000"+
		"A@\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000"+
		"\u0000CE\u0003\f\u0006\u0000DF\u0005\u0004\u0000\u0000ED\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000FH\u0001\u0000\u0000\u0000G?\u0001\u0000"+
		"\u0000\u0000HK\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001"+
		"\u0000\u0000\u0000JL\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000"+
		"LN\u0005\t\u0000\u0000M4\u0001\u0000\u0000\u0000M6\u0001\u0000\u0000\u0000"+
		"N\u000b\u0001\u0000\u0000\u0000OT\u0003\n\u0005\u0000PT\u0003\u0002\u0001"+
		"\u0000QT\u0003\u000e\u0007\u0000RT\u0003\u0010\b\u0000SO\u0001\u0000\u0000"+
		"\u0000SP\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000SR\u0001\u0000"+
		"\u0000\u0000T\r\u0001\u0000\u0000\u0000UW\b\u0000\u0000\u0000VU\u0001"+
		"\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000"+
		"XY\u0001\u0000\u0000\u0000Y\u000f\u0001\u0000\u0000\u0000Za\u0003\b\u0004"+
		"\u0000[]\b\u0001\u0000\u0000\\[\u0001\u0000\u0000\u0000]^\u0001\u0000"+
		"\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_a\u0001"+
		"\u0000\u0000\u0000`Z\u0001\u0000\u0000\u0000`\\\u0001\u0000\u0000\u0000"+
		"a\u0011\u0001\u0000\u0000\u0000\u0011\u0016\u0018\u001a\"&).9=AEIMSX^"+
		"`";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}