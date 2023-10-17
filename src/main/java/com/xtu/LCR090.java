package com.xtu;

public class LCR090 {
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int max1 = robMax(nums, 0, nums.length - 2);
        int max2 = robMax(nums, 1, nums.length - 1);
        return Math.max(max1, max2);
    }

    public static int robMax(int[] nums, int left, int right) {
        int dp[] = new int[right - left + 2];
        for (int i = left; i <= right; i++) {
            if (i - left == 0) {
                dp[1] = nums[i];
            } else if (i - left == 1) {
                dp[2] = Math.max(nums[i], nums[i - 1]);
            } else {
                dp[i - left + 1] = Math.max(dp[i - left], dp[i - left - 1] + nums[i - left]);
            }
        }
        return dp[right - left + 1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,1,1}));
    }
}
