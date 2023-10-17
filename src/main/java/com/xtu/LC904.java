package com.xtu;

import java.util.HashMap;
import java.util.Stack;

public class LC904 {
    public static void main(String[] args) {

    }

    public int totalFruit(int[] fruits) {
        int subLength = 0;
        int i = 0;
        int result = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < fruits.length; j++) {
            if (map.containsKey(fruits[j])) {
                map.put(fruits[j], map.get(fruits[j]) + 1);
            } else {
                map.put(fruits[j], 1);
            }
            while (map.size() > 2) {
                if (map.get(fruits[i]) == 1) {
                    map.remove(fruits[i]);
                } else {
                    map.put(fruits[i], map.get(fruits[i]) - 1);
                }
                i++;
            }
            subLength = j - i + 1;
            result = result > subLength ? result : subLength;
        }
        return result;
    }
}
