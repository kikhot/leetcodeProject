package com.xtu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class XMTest2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s1 = in.next();
        String[] split = s1.split(",");
        //用一个map进行存储，key为该工序，value为该工序所需依赖的所有工序
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            //：左边和右边各有两个数
            String[] split1 = split[i].split(":");
            int num1 = Integer.valueOf(split1[0]);
            int num2 = Integer.valueOf(split1[1]);
            //如果num2 中的前工序有num1则死锁，不能完成
            if (map.containsKey(num2)) {
                HashSet<Integer> tempset = map.get(num2);
                if (tempset.contains(num1)) {
                    System.out.println(0);
                    return;
                }
            }
            if (map.containsKey(num1)) {
                HashSet<Integer> tempNumset = map.get(num1);
                tempNumset.add(num2);
                map.put(num1, tempNumset);
            } else {
                HashSet<Integer> tempNumset = new HashSet<>();
                tempNumset.add(num2);
                map.put(num1, tempNumset);
            }
        }
        System.out.println(1);
    }
}
