package com.xtu;

/**
 * 执行用时：4 ms, 在所有 Java 提交中击败了75.04%的用户
 * 内存消耗：40.8 MB, 在所有 Java 提交中击败了8.95%的用户
 */
public class lc2006 {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[i]-nums[j]==k || nums[i]-nums[j]==-k){
                    count++;
                }
            }
        }
        return count;
    }

}
