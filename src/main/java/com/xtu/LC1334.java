package com.xtu;

import java.util.Arrays;

/**
 * 使用Floyd算法
 */
public class LC1334 {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // 构建邻接矩阵
        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE / 2);

        for (int i = 0; i < edges.length; i++) {
            adjMatrix[edges[i][0]][edges[i][1]] = edges[i][2];
            adjMatrix[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        // Floyd算法
        for (int k = 0; k < n; k++) {
            adjMatrix[k][k] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adjMatrix[i][j] = Math.min(adjMatrix[i][k] + adjMatrix[k][j], adjMatrix[i][j]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int flagCount = 0;
            for (int j = 0; j < n; j++) {
                if (adjMatrix[i][j] <= distanceThreshold) {
                    flagCount++;
                }
            }
            if (flagCount <= count) {
                count = flagCount;
                result = i;
            }
        }
        return result;
    }

}
