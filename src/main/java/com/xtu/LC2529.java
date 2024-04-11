package com.xtu;

public class LC2529 {

    public int maximumCount(int[] nums) {
        int left = lowerIndex(nums, -1);
        int right = lowerIndex(nums, 0);
        return Math.max(left + 1, nums.length - right - 1);
    }


    public int lowerIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
