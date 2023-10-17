package com.xtu;

import java.util.*;

public class TXTest2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n-1];
            for(int j=0;j<n;j++){
                a[j] = in.nextInt();
            }
            int[] sortA = a.clone();
            Arrays.sort(sortA);
            if(n%2==1){
                System.out.print(sortA[n/2]+ " ");
            }else{
                System.out.print((double)(sortA[n/2-1]+sortA[n/2])/2 + " ");
            }
            for(int j=0;j<n-1;j++){
                b[j] = in.nextInt();
                a[b[j]-1] = -1;
                sortA = a.clone();
                Arrays.sort(sortA);
                if((n-j-1)%2==1){
                    System.out.print(sortA[(n-j-1)/2+j+1] + " ");
                }else{
                    System.out.print((double)(sortA[(n-j-1)/2+j+1]+sortA[(n-j-1)/2+j])/2 + " ");
                }
            }
            System.out.println();

        }
    }
}
