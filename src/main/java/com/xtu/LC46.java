package com.xtu;

import java.util.*;

public class LC46 {

    public static List<List<Integer>> resultList = new ArrayList<>();


    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(nums, path);
        return resultList;
    }


    public static void backtrack(int[] nums, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            resultList.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])) {
                path.add(nums[i]);
                backtrack(nums, path);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
    }
}
