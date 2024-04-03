package com.xtu.xiaomi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 正整数n
        int n = in.nextInt();
        int[] nums_a = new int[n];
        // 数组中的最大值
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            nums_a[i] = in.nextInt();
            maxVal = Math.max(maxVal, nums_a[i]);
        }

        //从前到后遍历数组，如果数组中的值翻倍大于maxVal,则f(n) = 这个值，else f(n) = maxVal
        for (int i = 0; i < n; i++) {
            long num = (long) nums_a[i] * 2;
            if (num > maxVal) {
                System.out.print(num + " ");
            } else {
                System.out.print(maxVal + " ");
            }
        }

    }
}
