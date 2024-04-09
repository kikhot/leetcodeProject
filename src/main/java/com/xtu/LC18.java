package com.xtu;

import java.util.*;

public class LC18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> list = new LinkedList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        resultList.add(list);
                        while (left < right && nums[left] == nums[++left]) ;
                        while (left < right && nums[right] == nums[--right]) ;
                    } else if (sum < target) {
                        while (left < right && nums[left] == nums[++left]) ;
                    } else {
                        while (left < right && nums[right] == nums[--right]) ;
                    }
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296);
    }
}