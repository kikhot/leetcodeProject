package com.xtu;

import java.util.*;

public class LC2007 {

    public int[] findOriginalArray(int[] changed) {
        Map<Integer, Integer> map = new HashMap<>();
        if (changed.length % 2 == 1) {
            return new int[0];
        }
        Arrays.sort(changed);
        for (int i = 0; i < changed.length; i++) {
            map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
        }
        int[] result = new int[changed.length / 2];
        int index = 0;
        for (int num : changed) {
            if (map.get(num) == 0) {
                continue;
            }
            map.put(num, map.get(num) - 1);
            if (map.getOrDefault(num * 2, 0) <= 0) {
                return new int[0];
            }
            map.put(num * 2, map.get(num * 2) - 1);

            result[index++] = num;
        }
        return result;
    }
}
