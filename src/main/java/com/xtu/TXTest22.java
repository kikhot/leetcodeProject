package com.xtu;

import java.util.Scanner;

public class TXTest22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextLong();
        }
        for (int i = 0; i < k; i++) {
            int minIndex = 0;
            long minNum = a[0];
            for (int j = 1; j < n; j++) {
                if (minNum>a[j]){
                    minNum = a[j];
                    minIndex = j;
                }
            }
            if(minNum%2==0){
                a[minIndex] = minNum*2+1;
            }else{
                a[minIndex] = minNum*2;
            }
        }
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        System.out.println(sum);
    }
}
