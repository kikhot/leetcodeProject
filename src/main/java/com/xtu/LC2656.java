package com.xtu;

import java.util.Arrays;

public class LC2656 {

    public int maximizeSum(int[] nums, int k) {
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        return ((maxVal + k - 1) * (maxVal + k) - maxVal * (maxVal - 1)) / 2;
    }
}
