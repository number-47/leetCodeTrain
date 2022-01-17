package com.number47.train.leetcode.editor.cn;
//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 
// 👍 517 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
        int[] nums1 = {5, 0, 0, 6, 1, 6, 2, 2, 4};
        int[] nums2 = {4, 7, 9, 7, 6, 7};
        int[] nums = solution.intersect(nums1, nums2);
        for (Integer i : nums) {
            System.out.println(i);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        /**双指针 **/
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length;
        int length2 = nums2.length;
        int left = 0;
        int right = 0;
        int r = 0;
        int[] intersection = new int[Math.min(length1, length2)];
        while (left < length1 && right < length2) {
            if (nums1[left] < nums2[right]){
                left++;
            }  else if (nums1[left] > nums2[right]){
                right++;
            } else {
                intersection[r] = nums2[right];
                r++;
                right++;
                left++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, r);

        /**哈希解法**/
       /* if (nums1.length < nums2.length){
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer> map = new HashMap<>();
        // 最长的一个数组
        for (int i = 0; i < nums1.length; i++) {
            if (map.get(nums1[i]) == null){
                map.put(nums1[i],0);
            }
            map.put(nums1[i],map.get(nums1[i]) + 1);
        }
        // 遍历短的数组
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (map.get(nums2[i]) != null){
                if (map.get(nums2[i]) > 0){
                    intersection[index] = nums2[i];
                    map.put(nums2[i],map.get(nums2[i]) - 1);
                    index ++ ;
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}