package com.xtu;

import java.util.HashMap;
import java.util.Map;

public class LC1702 {

    public String maximumBinaryString(String binary) {
        Map<Character, Integer> map = new HashMap<>();
        int flagIndex = -1;
        for (int i = 0; i < binary.length(); i++) {
            if (flagIndex == -1 && binary.charAt(i) == '0') {
                flagIndex = i;
            }
            map.put(binary.charAt(i), map.getOrDefault(binary.charAt(i), 0) + 1);
        }
        if (!map.containsKey('0') || map.get('0') <= 1) {
            return binary;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            if (i != flagIndex + map.get('0') - 1) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return sb.toString();
    }
}
