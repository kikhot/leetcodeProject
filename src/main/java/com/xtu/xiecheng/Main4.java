package com.xtu.xiecheng;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] uv = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            uv[i][0] = in.nextInt();
            uv[i][1] = in.nextInt();
        }
        resultCount = new int[n];
        for (int i = 0; i < n; i++) {
            int[] flag = new int[n];
            dfs(uv, i + 1, i, 0, flag);
        }
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(resultCount[i], maxValue);
        }
        for (int i = 0; i < n; i++) {
            if (maxValue == resultCount[i]) {
                System.out.println(resultCount[i] + 1);
            } else {
                System.out.println(maxValue);
            }
        }
    }

    public static int resultCount[];

    public static void dfs(int[][] uv, int root, int index, int count, int[] flag) {
        for (int i = 0; i < uv.length; i++) {
            if (uv[i][0] == root && flag[i] == 0) {
                if (resultCount[index] < count + 1) {
                    resultCount[index] = count + 1;
                }
                flag[i] = 1;
                dfs(uv, uv[i][1], index, count + 1, flag);
            }
            if (uv[i][1] == root && flag[i] == 0) {
                if (resultCount[index] < count + 1) {
                    resultCount[index] = count + 1;
                }
                flag[i] = 1;
                dfs(uv, uv[i][0], index, count + 1, flag);
            }
        }
    }
}
