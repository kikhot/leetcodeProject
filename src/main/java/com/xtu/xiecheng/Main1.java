package com.xtu.xiecheng;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'y' && str.charAt(i + 1) == 'u') {
                count++;
            }
        }
        System.out.println(count);
    }
}
