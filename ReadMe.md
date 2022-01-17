# leetcode plugin模板配置
## TempFilePath: 
```
F:\github\leetCodeTrain\src\com\number47\train
```
CodeFileName: $!velocityTool.camelCaseName(${question.titleSlug})
## CodeTemplate:
```
package com.number47.train.leetcode.editor.cn;
${question.content}

public class $!velocityTool.camelCaseName(${question.titleSlug}) {
public static void main(String[] args) {
Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
}
${question.code}
}
```
