grammar Analyze;

//  Antrlのテストと構文メモ -> ./ANTLR.md

/** lexer */
GROUP: [0-9]+;
NAME: [a-zA-Z][a-zA-Z0-9]*;
WS: [\u0020\u3000\r\n\t]+; // \u0020:半角 \u3000:全角スペース
fragment ESCAPE: '\\';
E_DOLLAR: ESCAPE '$';
E_ESCAPE: ESCAPE '\\';
E_COMMA: ESCAPE ',';
DOLLAR: '$';
ANY: .;

/** parser */
parse: (group | var | (text | text_warn))*;

/**
 * group: $0 $10
 */
// $1 ${1}  数字部分が 正規表現の GROUP になる
group: '$' GROUP | '$' '{' WS? GROUP WS? '}';

/**
 * text: a,12-bc \\ \$
 */
// 正常な文字: a,12-bc \\ \$
text: ~('$' | '\\')+;
// 警告を出すべき文字: \ $
text_warn: ('$' | '\\');

/**
 * var: $a ${ab} ${a, 1, $a, ${a, 1}
 */
var: '$' NAME | '$' '{' WS? NAME WS? (',' WS? arg WS?)* '}';
arg: var | group | arg_text | arg_warn;
// arg の正常な文字列
arg_text: (~('$' | ',' | '\\' | '}'))+;
// arg の警告を出すべき文字列. 「ｶﾗ」or 単体の\}を含む文字
arg_warn: | ~(',' | '}')+;

/**
 不正な可能性のある文字を
 => text は問題のあるポイントを直接指摘できるようにするため
 => arg は分割すると面倒くさいのと、
 __ 長い文字は指定しないだろうからいいかなと
 */