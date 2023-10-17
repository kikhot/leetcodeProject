package com.xtu;

public class LC198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            if (i == 1) {
                dp[i] = nums[0];
            } else if (i == 2) {
                dp[i] = Math.max(nums[0], nums[1]);
            } else {
                dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
            }
        }
        return dp[nums.length];
    }
}
