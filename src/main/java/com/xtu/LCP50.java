package com.xtu;

import java.util.Arrays;

public class LCP50 {
    public int giveGem(int[] gem, int[][] operations) {
        // 模拟
        for (int i = 0; i < operations.length; i++) {
            int tranNum = gem[operations[i][0]] / 2;
            gem[operations[i][0]] -= tranNum;
            gem[operations[i][1]] += tranNum;
        }
        Arrays.sort(gem);
        return gem[gem.length - 1] - gem[0];
    }
}
