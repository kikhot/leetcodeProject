package com.xtu;

import java.util.HashSet;

public class LC2924 {

    /**
     * 使用HashSet来存储当前最大的队伍
     *
     * @param n     n支队伍
     * @param edges 图的边
     * @return 唯一的冠军
     */
    public int findChampion(int n, int[][] edges) {
        HashSet<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            resultSet.add(i);
        }
        for (int i = 0; i < edges.length; i++) {
            int v = edges[i][1];
            resultSet.remove(v);
        }
        return resultSet.size() > 1 ? -1 : resultSet.stream().findFirst().get();
    }
}
