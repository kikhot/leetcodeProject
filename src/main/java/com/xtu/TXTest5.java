package com.xtu;

import java.util.Scanner;

public class TXTest5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            int minBit = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 0; j < n; j++) {
                if (a[j] != 0) {
                    int bit = Integer.lowestOneBit(a[j]);
                    if (bit < minBit) {
                        minBit = bit;
                        minIndex = j;
                    }
                }
            }

            if (minIndex >= 0) {
                a[minIndex] ^= minBit;
            }
        }
        int sum = 0;
        for (int num : a) {
            sum += num;
        }
        System.out.println(sum);
    }
}
