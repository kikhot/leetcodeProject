package com.xtu;


import java.util.HashMap;
import java.util.Map;

public class LC76 {


    public static String minWindow(String s, String t) {
        Map<Character, Integer> charNumMap = new HashMap<>();
        for (Character ch : t.toCharArray()) {
            charNumMap.merge(ch, 1, Integer::sum);
        }
        int slowIndex = 0;
        int resultLen = Integer.MAX_VALUE;
        String result = "";
        for (int fastIndex = 0; fastIndex < s.length(); fastIndex++) {
            if (charNumMap.containsKey(s.charAt(fastIndex))) {
                charNumMap.merge(s.charAt(fastIndex), -1, Integer::sum);
            }
            while (hasAllT(charNumMap)) {
                if (fastIndex - slowIndex + 1 < resultLen) {
                    resultLen = fastIndex - slowIndex + 1;
                    result = s.substring(slowIndex, fastIndex + 1);
                }
                if (charNumMap.containsKey(s.charAt(slowIndex))) {
                    charNumMap.merge(s.charAt(slowIndex), 1, Integer::sum);
                }
                slowIndex++;
            }
        }
        return result;
    }

    public static boolean hasAllT(Map<Character, Integer> charNumMap) {
        for (Integer val : charNumMap.values()) {
            if (val > 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
