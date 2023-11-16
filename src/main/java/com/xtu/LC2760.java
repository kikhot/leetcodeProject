package com.xtu;

public class LC2760 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLen = 0;
        int count = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > threshold || nums[i] % 2 != 0) {
                i++;
                continue;
            }
            i++;
            count++;
            while (i < nums.length && nums[i] % 2 != nums[i - 1] % 2 && nums[i] <= threshold) {
                i++;
                count++;
            }
            maxLen = Math.max(count, maxLen);
            count = 0;
        }
        return maxLen;
    }
}
