package com.xtu;

import java.util.HashSet;
import java.util.Set;

/**
 * 执行用时：14 ms, 在所有 Java 提交中击败了37.89%的用户
 * 内存消耗：42.1 MB, 在所有 Java 提交中击败了60.21%的用户
 * 通过测试用例：
 * 74 / 74
 */
public class LC1684 {

    public int countConsistentStrings(String allowed, String[] words){
        Set<Character> set = new HashSet<>();
        int count = 0;
        int flag = 1;
        for(int i=0;i<allowed.length();i++){
            set.add(allowed.charAt(i));
        }
        for(String str : words){
            for(int i=0;i<str.length();i++){
                if(!set.contains(str.charAt(i))){
                    flag = 0;
                }
            }
            if(flag == 1){
                count++;
            }else{
                flag = 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
