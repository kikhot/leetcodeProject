package com.xtu;

/**
 * LeetCode 70. 爬楼梯
 *
 * @author Quixote
 * @date 2024/2/4
 */

public class LC70 {

    // 使用动态规划来处理
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if (n == 1 || n == 2)
            return n;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 递归超时，本题递归不了
//    public int climbStairs(int n) {
//        return dfs(n);
//    }
//
//    public int dfs(int n) {
//        if (n == 1 || n == 2) {
//            return n;
//        }
//        return dfs(n - 1) + dfs(n - 2);
//    }
}
