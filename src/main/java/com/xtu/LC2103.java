package com.xtu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC2103 {
    public int countPoints(String rings) {
        Map<Integer, Set> map = new HashMap<Integer, Set>();
        Integer result = 0;
        for (int i = 0; i < rings.length() / 2; i++) {
            int key = Integer.valueOf(String.valueOf(rings.charAt(2 * i + 1)));
            if (map.containsKey(key)) {
                map.get(key).add(rings.charAt(2 * i));
            } else {
                Set<Character> set = new HashSet<>();
                set.add(rings.charAt(2 * i));
                map.put(key, set);
            }

        }
        for (Set val : map.values()) {
            if (val.size() == 3)
                result++;
        }
        return result;
    }
    public final Integer a;
    public LC2103(Integer a){
        this.a = a;
    }

    public Integer getA(){
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf('1'));
    }
}
