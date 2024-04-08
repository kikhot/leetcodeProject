package com.xtu;

import java.util.HashMap;
import java.util.Map;

public class LC242 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < t.length(); i++) {
            map.merge(t.charAt(i), -1, Integer::sum);
        }
        for (Integer val : map.values()) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
