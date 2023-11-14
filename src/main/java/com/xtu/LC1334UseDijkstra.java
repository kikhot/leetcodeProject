package com.xtu;

import java.util.Arrays;

/**
 * 使用Dijkstra算法求解
 */
public class LC1334UseDijkstra {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // 构建邻接矩阵
        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE / 2);

        for (int i = 0; i < edges.length; i++) {
            adjMatrix[edges[i][0]][edges[i][1]] = edges[i][2];
            adjMatrix[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        for (int i = 0; i < n; i++)
            adjMatrix[i][i] = 0;

        //Dijkstra算法
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            graph[i] = Dijkstra(adjMatrix, i);
        }


        int result = Integer.MAX_VALUE / 2;
        int count = Integer.MAX_VALUE / 2;
        for (int i = 0; i < n; i++) {
            int flagCount = 0;
            for (int j = 0; j < n; j++) {
                if (graph[i][j] <= distanceThreshold) {
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


    /**
     * Dijkstra算法
     *
     * @param graph 图
     * @param v     源点
     * @return 最终v所到各个节点的最小距离
     */
    private static int[] Dijkstra(int[][] graph, int v) {
        int n = graph.length;
        int[] D = new int[n];   // D:int型数组，记录到图中各个节点的最短路径的值
        boolean[] S = new boolean[n];   // S:bool型数组，加入最短路径的结果集，初始时只有源节点
        int[] Pr = new int[n];  // Pr:int型数组，记录图中节点到源节点的前驱，在Path输出时递归即可输出最短路径
        for (int i = 0; i < n; i++) {
            D[i] = graph[v][i];
            S[i] = false;
            if (D[i] < Integer.MAX_VALUE / 2) {
                Pr[i] = v;  // 前驱节点
            }
        }
        S[v] = true;
        // 初始化结束,求最短路径，并加入S集
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE / 2;
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (D[j] < min && !S[j]) {
                    temp = j;
                    min = D[j];
                }
            }
            S[temp] = true;
            //更新从源点出发至其余点的最短路径 通过temp
            for (int j = 0; j < n; j++) {
                if (!S[j] && D[j] > graph[temp][j] + D[temp]) {
                    D[j] = graph[temp][j] + D[temp];
                    Pr[j] = temp;
                }
            }
        }
        return D;
    }

    public static void main(String[] args) {
        Dijkstra(new int[][]{
                {0, 2, 1000, 6}
                , {2, 0, 3, 2}
                , {1000, 3, 0, 2}
                , {6, 2, 2, 0}}, 0);
    }
}
