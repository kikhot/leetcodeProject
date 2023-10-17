package com.xtu;

import java.util.Scanner;

public class JDTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int H = in.nextInt();
        int[] h = new int[n];
        int[] p = new int[n];
        int[] s = new int[m];
        int maxHigh = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            s[i] = in.nextInt();
            maxHigh = Math.max(maxHigh, s[i]);
        }

        int[] realHigh = new int[n];
        int hongHigh = H + maxHigh;
        for (int i = 0; i < n; i++) {
            realHigh[i] = h[i] + s[p[i] - 1];
            if (realHigh[i] < hongHigh) {
                count++;
            }
        }
        System.out.println(count);

    }
}
