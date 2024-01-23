package com.xtu;

public class LC2765 {
    public static int alternatingSubarray(int[] nums) {
        int i = 0;
        int result = 0;
        while (i < nums.length) {
            int subCount = 0;
            int j = i + 1;
            while (j < nums.length) {
                if (nums[j] - nums[j - 1] == Math.pow(-1, j - i - 1)) {
                    subCount++;
                    j++;
                } else {
                    break;
                }
            }
            if (subCount == 0) {
                i++;
            } else {
                result = Math.max(result, subCount);
                i = j - 1;
            }
        }
        return result == 0 ? -1 : result + 1;
    }

    public static void main(String[] args) {
        alternatingSubarray(new int[]{21, 9, 5});
    }
}
