package com.number47.train.leetcode.editor.cn;

/**
 * @author Administrator
 * @date 2021/11/18 10:47
 * @description
 */
public class VersionControl {

   boolean isBadVersion(int version){
       if (version == 1){
           return false;
       } else if (version == 4 || version == 5 || version == 2 || version == 3){
           return true;
       } else {
           return true;
       }
   }
}
