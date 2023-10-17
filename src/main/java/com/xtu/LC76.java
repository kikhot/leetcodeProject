package com.xtu;


import java.util.HashMap;

public class LC76 {
    public static String minWindow(String s, String t) {
        int resultLen = Integer.MAX_VALUE;
        String result = "";
        int subLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> processMap = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            } else {
                map.put(t.charAt(i), 1);
            }
        }
        int i = 0; //窗口第一个指针
        // 滑动窗口
        for (int j = 0; j < s.length(); j++) {
            if (processMap.containsKey(s.charAt(j))) {
                processMap.put(s.charAt(j), processMap.get(s.charAt(j)) + 1);
            } else {
                processMap.put(s.charAt(j), 1);
            }
            sb.append(s.charAt(j));
            while (checkSub(map, processMap)) {
                subLength = j - i + 1;
                if(resultLen>subLength){
                    resultLen = subLength;
                    result = sb.toString();
                }
                if (processMap.get(s.charAt(i)) <= 1) {
                    processMap.remove(s.charAt(i));
                } else {
                    processMap.put(s.charAt(i), processMap.get(s.charAt(i)) - 1);
                }
                sb.delete(0,1);
                i++;
            }
        }
        return result;
    }


    public static boolean checkSub(HashMap<Character, Integer> map, HashMap<Character, Integer> processMap) {
        for (char ch : map.keySet()) {
            if (!processMap.containsKey(ch)) {
                return false;
            }
            if (map.get(ch) > processMap.get(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        minWindow("ADOBECODEBANC", "ABC");
    }
}
