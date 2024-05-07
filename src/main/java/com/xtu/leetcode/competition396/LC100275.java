package com.xtu.leetcode.competition396;

import java.util.HashMap;

public class LC100275 {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        int maxVal = 0;
        for (int i = 0; i < word.length() / k; i++) {
            String substring = word.substring(i, (i + 1) * k);
            map.put(substring, map.getOrDefault(substring, 0) + 1);
            maxVal = Math.max(map.get(substring), maxVal);
        }
        return word.length() / k - maxVal;
    }
}
