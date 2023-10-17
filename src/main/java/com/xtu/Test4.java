package com.xtu;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int increase = 1;
        int[] nums = new int[n];
        nums[0] = 1;
        int i = 1;
        for(i=1;i<nums.length;i++){
            if(m-nums[i-1] == n-i){
                break;
            }
            nums[i] = nums[i-1]+increase;
            increase++;
        }

        for(;i<nums.length;i++){
            nums[i] = nums[i-1]+1;
        }
        for(int j=0;j<nums.length;j++){
            System.out.print(nums[j] + " ");
        }
    }
}
