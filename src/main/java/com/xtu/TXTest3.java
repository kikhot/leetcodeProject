package com.xtu;

import java.util.Arrays;
import java.util.Scanner;

public class TXTest3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }
        int[] sortedA = a.clone();
        Arrays.sort(sortedA);
        int count = 0;
        int cowPower = 0;
        for(int i=0;i<n;i++){
            int monsterPower = sortedA[i];
            if(cowPower < monsterPower){
                count += monsterPower - cowPower;
            }
            cowPower = monsterPower;
        }
        System.out.println(count);
    }
}
