package com.xtu;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextLong();
            sum += a[i];
        }
        long sum2 = a[0];
        long min = Long.MAX_VALUE;
        for (int i = 1; i < a.length; i++) {
            if ((long)(sum2 - a[i]) < 0) {
            } else {
                if (((long)(sum - 2*a[i]) >= 0) && (min > (long)(sum - 2*a[i]))) {
                    min = sum - 2 * a[i];
                }
            }
            sum2 += a[i];
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
