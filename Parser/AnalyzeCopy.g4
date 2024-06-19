grammar AnalyzeCopy;

//  Antrlのテストと構文メモ -> ./ANTLR.md

/** lexer */
GROUP: [0-9]+;
NAME: [a-zA-Z][a-zA-Z0-9]+;
WS: [\u0020\u3000\r\n\t]+; // \u0020:半角 \u3000:全角スペース
ANY: .;

/** parser */
parse: (var | var_group | (text | escape_doller | single_doller))*;

/* $a ${a} ${a1, b, 2}
 1つ目 ($x ${x, ..} のx) が NAME になる
 2つ目以降 (${?, x,x,...} のx) が args になる
 */
var: '$' NAME | '$' '{' WS? NAME WS? (',' WS? arg WS?)* '}';
// $1 ${1}  数字部分が 正規表現の GROUP になる
var_group: '$' GROUP | '$' '{' WS? GROUP WS? '}';
/* ${?, x, x,} の x 部分
 args は $1 や ${x} なども可能
 つまり var は ${a, ${b, ${c} } } のように変数の入れ子が可能
 */
arg: var | var_group | var_text | arg_error;
// arg の文字として正常な値
var_text: ('$' '$' | ~('$' | ',' | '}'))+;
// arg の文字として不正な可能性のある値. 「ｶﾗ」or 単体の$を含む
arg_error: | ~(',' | '}')+;

// どれにも一致しない場合textになる
text: (~'$')+;
// エスケープ $$
escape_doller: '$' '$';
// 単体の $
single_doller: '$';