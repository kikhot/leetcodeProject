package com.xtu;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class lanqiao12 {
    //时间显示
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        double second = input.nextDouble();
//        int oneDay = 24*60*60*1000;
//        int nums = (int)(second%oneDay/1000);
//        String str = "";
//        if((nums/(60*60))/10 == 0)
//            str += "0"+nums/(60*60)+":";
//        else
//            str += nums/(60*60)+":";
//        if(((nums%(60*60))/60)/10 == 0)
//            str += "0"+nums%(60*60)/60+":";
//        else
//            str += nums%(60*60)/60+":";
//        if(nums%60/10 == 0)
//            str += "0"+nums%60;
//        else
//            str += nums%60;
//
//        System.out.println(str);
//    }


//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        int m = input.nextInt();
//        Integer nums[] = new Integer[n];
//        for(int i=0;i<nums.length;i++){
//            nums[i] = i+1;
//        }
//        for(int i=0;i<m;i++){
//            int pi = input.nextInt();
//            int position = input.nextInt();
//            if(pi == 0){
//                Arrays.sort(nums, 0,position, Collections.reverseOrder());
//            }else if(pi == 1){
//                Arrays.sort(nums,position-1,nums.length);
//            }
//        }
//        for(int i=0;i<nums.length;i++){
//            System.out.print(nums[i] + " ");
//        }
//    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int nums[] = new int[N];
        int count = 0;
        for(int i=0;i<N;i++){
            nums[i] = input.nextInt();
        }
        Arrays.sort(nums);
        int result[] = new int[nums[N-1]*2+1];
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                result[nums[j]-nums[i]]++;
            }
            for(int j=0;j<N;j++){
                result[nums[j]+nums[i]]++;
            }
            result[nums[i]]++;
        }
        for(int i=0;i<result.length;i++){
            if(result[i] != 0){
                count++;
            }
        }
        System.out.println(count);
    }

}
