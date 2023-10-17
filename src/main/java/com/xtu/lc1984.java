package com.xtu;

import java.util.Arrays;

/**
 * 执行用时：4 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：41.9 MB, 在所有 Java 提交中击败了5.17%的用户
 */
public class lc1984 {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int max = Integer.MAX_VALUE;
        for(int i=0;i<nums.length-k+1;i++){
            if(nums[i+k-1]-nums[i] <max){
                max = nums[i+k-1]-nums[i];
            }
        }

        return max;
    }
}
