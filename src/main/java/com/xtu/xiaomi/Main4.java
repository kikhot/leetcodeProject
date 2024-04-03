package com.xtu.xiaomi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main4 {

    public static int resultCount = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        StringBuffer balStr = new StringBuffer();
        demo(str, balStr, 0, new HashMap<>());
        System.out.println(resultCount);
    }


    public static void demo(String str, StringBuffer balStr, int index, Map<Character, Integer> map) {
        if (map.size() > 2 || index >= str.length()) {
            return;
        }
        if (map.size() == 2) {
            int count = 0;
            for (Character ch : map.keySet()) {
                if (count == 0) {
                    count = map.get(ch);
                } else {
                    if (count == map.get(ch)) {
                        System.out.println(balStr);
                        resultCount++;
                    }
                }
            }
        }

        // 处理index这个字符
        balStr.append(str.charAt(index));
        if (!map.containsKey(str.charAt(index))) {
            map.put(str.charAt(index), 1);
        } else {
            map.put(str.charAt(index), map.get(str.charAt(index)) + 1);
        }
        demo(str, balStr, index + 1, map);
        balStr.delete(balStr.length()-1, balStr.length());
        if(map.get(str.charAt(index)) == 1){
            map.remove(str.charAt(index));
        }else{
            map.put(str.charAt(index), map.get(str.charAt(index)) - 1);
        }
        // 不处理index这个字符
        demo(str, balStr, index + 1, map);

    }
}
