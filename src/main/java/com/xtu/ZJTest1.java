package com.xtu;

import java.util.Arrays;
import java.util.HashMap;

public class ZJTest1 {
    public static final HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        map.put(1,11);
        map.put(2,22);
        System.out.println(map.get(1));
    }
}
