## VSCodeでAntlrテスト

参考URL: https://qiita.com/i-tanaka730/items/4eeaae247f70895c3456

1. VSCode拡張機能をインストール\
  https://marketplace.visualstudio.com/items?itemName=mike-lischke.vscode-antlr4
2. .vscode/launch.json に以下の記述\
  > ```configurations
  > {
  >     "name": "Debug ANTLR4",
  >     "type": "antlr-debug",
  >     "request": "launch",
  >     "input": "test.txt", // テストファイル
  >     "grammar": "Analyze.g4", // .g4ファイル
  >     "printParseTree": false, // 結果をコンソールに表示するか
  >     "visualParseTree": true // 結果をGUIに表示するか
  > }
  > ```
3. VSCode でデバッグ実行


## Antrl構文メモ 
1文字目がAでなく2文字目がBでない2文字の繰り返し  
**OK**: `"BA"` `"1234"` **NG**: `"A2"` `"1"`  
`(~A ~B)+`

ABCを含まない文字列  
**OK**: `"123"` **NG**: `"A23"`  
`~(A | B | C)+`

ABのいずれかを含まない文字列 (全ての場合で一致するので無意味)  
`(~A | ~B)+`

ABCを含まない文字列で構成された3文字の繰り返し  
**OK**: `"123"` `"123456"` **NG**: `"12"` `"12A"`  
`~(A B C)+`

