package com.xtu;

import java.util.Arrays;

public class LC377 {

//    public int combinationSum4(int[] nums, int target) {
//        int[] path = new int[target + 1];
//        Arrays.fill(path, -1);
//        return dfs(target, nums, path);
//    }
//
//
//    public int dfs(int i, int[] nums, int[] path) {
//        if (i == 0) {
//            return 1;
//        }
//
//        if (path[i] != -1) {
//            return path[i];
//        }
//
//        int res = 0;
//        for (int x : nums) {
//            if (x <= i) {
//                res += dfs(i - x, nums, path);
//            }
//        }
//
//        return path[i] = res;
//
//    }


    /**
     * dp
     */
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            int res = 0;
            for (int c : nums) {
                if (c <= i) {
                    res += dp[i - c];
                }
            }
            dp[i] = res;
        }
        return dp[target];
    }
}
