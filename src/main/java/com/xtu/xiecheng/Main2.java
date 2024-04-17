package com.xtu.xiecheng;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] ai = new long[n];
        long[] bi = new long[n];
        Map<Long, Integer> ciMap = new HashMap<>();
        int resultCount = 0;
        for (int i = 0; i < n; i++) {
            ai[i] = in.nextLong();
        }
        for (int i = 0; i < n; i++) {
            bi[i] = in.nextLong();
        }
        for (int i = 0; i < n; i++) {
            Long num = in.nextLong();
            ciMap.put(num, ciMap.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            Long sum = ai[i] + bi[i];
            if (ciMap.getOrDefault(sum, 0) > 0) {
                resultCount++;
                ciMap.put(sum, ciMap.get(sum) - 1);
            }
        }

        System.out.println(resultCount);

    }
}
