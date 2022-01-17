package com.number47.train.leetcode.editor.cn;
//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1692 👎 0


public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        String[] strs = new String[]{"dog","racecar","car"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String indexStr = strs[0];
        for (int k = 1; k < strs.length; k++) {
            indexStr = getCommonString(strs[k], indexStr);
        }
        return indexStr;
    }

        private String getCommonString(String str, String indexStr) {
        int result = 0;
        int length = indexStr.length();
            for (int i = 0; i <= length ; i++) {
                int indexOf = str.indexOf(indexStr);
                if (indexOf != 0){
                    indexStr = indexStr.substring(0,indexStr.length()-1);
                } else if (indexOf == 0){
                    result = 1;
                    break;
                }
            }
            if (result > 0){
                return indexStr;
            } else {
                return "";
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}