package com.xtu.zhongke;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] cost = new int[n];
        int[] dp = new int[n + 1];
        // dp[i] = min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2])
        for (int i = 0; i < n; i++) {
            cost[i] = in.nextInt();

        }
        for (int i = 0; i < n + 1; i++) {
            if (i == 0) {
                dp[i] = 0;
            } else if (i == 1) {
                dp[i] = 0;
            } else {
                dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            }

        }
        System.out.println(dp[n]);

    }
}
