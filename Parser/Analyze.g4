grammar Analyze;

//  Antrlのテストと構文メモ -> ./ANTLR.md

/** lexer */
GROUP: [0-9]+;
NAME: [a-zA-Z][a-zA-Z0-9]*;
WS: [\u0020\u3000\r\n\t]+; // \u0020:半角 \u3000:全角スペース
ESCAPED: '\\' (ESCAPE | DOLLAR | COMMA | CLOSE);
ESCAPE: '\\';
DOLLAR: '$';
COMMA: ',';
CLOSE: '}';
ANY: .;

/** parser */
parse: (fn | group | (warn | text))*;

/**
 * group: $0 $10
 */
// 正規表現のグループマッチ
group: '$' GROUP | '$' '{' WS? GROUP WS? '}';

/**
 * text: a,12-bc \\ \$
 */
// 正常な文字: a,12-bc \\ \$
text: ~(ESCAPE | '$' | ',' | '}')+;
// 警告を出すべき文字: エスケープされてない記号
warn: ESCAPE | '$' | ',' | '}';
empty:;

/**
 * fn: $a ${ab} ${a, 1, $a, ${a, 1}
 */
fn: '$' NAME | '$' '{' WS? NAME WS? (',' WS? arg WS?)* '}';
arg: fn | group | arg_text | arg_warn;
// arg の正常な文字列
arg_text: ~('$' | ',' | '\\' | '}')+;
// arg の警告を出すべき文字列. 「ｶﾗ」or 単体の\}を含む文字
arg_warn: empty | ~(',')+;