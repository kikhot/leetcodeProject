package com.xtu.leetcode.competition396;

import java.util.HashMap;

/**
 * error
 */
public class LC100283 {
    public int minAnagramLength(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int result = 0;
        boolean flag = true;
        for (Character ch : map.keySet()) {
            if (map.get(ch) == 1) {
                flag = false;
            }
        }
        if (flag) {
            for (Character ch : map.keySet()) {
                result += map.get(ch) - 1;
            }
        } else {
            for (Character ch : map.keySet()) {
                result += map.get(ch);
            }
        }

        return result;
    }
}
