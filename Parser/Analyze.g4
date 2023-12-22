grammar Analyze;

/*
 参考URL: https://qiita.com/i-tanaka730/items/4eeaae247f70895c3456
 
 VSCode拡張機能:
 https://marketplace.visualstudio.com/items?itemName=mike-lischke.vscode-antlr4
 
 ANTLRの情報は少ないのでChatGPTに聞くのが良いかも
 でもChatGPTもあんまり知らないみたい‥
 */

/** lexer */
GROUP: [0-9]+;
NAME: [a-zA-Z][a-zA-Z0-9]*;
WS: [ \u3000\r\n\t]+; // \u3000 は全角スペース
ANY: .;

/** parser */
parse: (var_group | var | text)*;

// $1 ${1}  数字部分が GROUP になる
var_group: '$' GROUP | '$' '{' WS? GROUP WS? '}';
/* $a ${a} ${a1, b, 2}
 1つ目 ($x ${x, ..} のx) が NAME になる
 2つ目以降 (${?, x,x,...} のx) が args になる
 */
var: '$' NAME | '$' '{' WS? NAME WS? (',' WS? arg WS?)* '}';
/* ${?, x, x,} の x 部分
 args は $1 や ${x} なども可能
 つまり var は ${a, ${b, ${c} } } のように変数の入れ子が可能
 */
arg: NAME | GROUP | var_group | var;
// どれにも一致しない場合textになる
text: '$' | (~'$')+;

// OK $1 $2 $a0 $bbbb ${ 1 } ${a} ${a0} ${b,c} ${a, 1, 3, b}

// NG {} ${1, 0} ${} ${,} ${a,$} $}{ bz1