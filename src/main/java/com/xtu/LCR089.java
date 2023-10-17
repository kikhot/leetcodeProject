package com.xtu;

public class LCR089 {
    public int rob(int[] nums){
        int[] dp = new int[nums.length+1];
        for(int i=1;i<=nums.length;i++){
            if(i==1){
                dp[i] = nums[i-1];
            }
            else if(i==2){
                dp[i] = Math.max(nums[i-1], nums[i-2]);
            }
            else{
                dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
            }
        }
        return dp[nums.length];
    }
}
