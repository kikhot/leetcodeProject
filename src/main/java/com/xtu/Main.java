package com.xtu;

import java.util.*;

public class Main {
    //成绩分析（蓝桥杯）
//    public static void main(String[] args) {
//        Scanner input  = new Scanner(System.in);
//        int n = input.nextInt();
//        int low = 0;
//        int high = 0;
//        int total = 0;
//        for(int i=0;i<n;i++){
//            if(i==0){
//                low = input.nextInt();
//                high = low;
//                total = low;
//            }
//            else{
//                int num = input.nextInt();
//                if(num < low)
//                    low = num;
//                if(num > high)
//                    high = num;
//                total += num;
//            }
//        }
//        System.out.println(high);
//        System.out.println(low);
//        System.out.println(String.format("%.2f",(double)total/n));
//    }

    //回文日期
//    public static Boolean isTrueDate(int date) {
//        int M[][] = {
//                {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
//                {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
//        };
//        int year = date/10000;
//        int month = date/100%100;
//        int day = date%100;
//        boolean isRun = false;
//        if((year%400)==0 || (year%4==0 && year%400!=0)){
//            isRun = true;
//        }
//        if(month<=0 || month>12)
//            return false;
//        if(isRun){
//            if(M[1][month-1]<day)
//                return false;
//        }else{
//            if(M[0][month-1]<day)
//                return false;
//        }
//        return true;
//    }
//    public static Boolean isHuiWen(int date){
//        if(date%10==date/10000000 && date/10%10==date/1000000%10 && date/100%10==date/100000%10 && date/1000%10==date/10000%10){
//            return true;
//        }
//        return false;
//    }
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int date = input.nextInt();
//        int A = date/10000000;
//        int B = date/1000000%10;
//        boolean flag = true;
//        int ABDate = A*10000000+B*1000000+A*100000+B*10000+B*1000+A*100+B*10+A;
//        while(flag){
//            date++;
//            if(isHuiWen(date) && isTrueDate(date)){
//                flag = false;
//            }
//        }
//        System.out.println(date);
//        flag = true;
//        while(flag){
//            if(B>3){
//                B = 0;
//                A++;
//            }else{
//                if(isTrueDate(ABDate)){
//                    if(date >= ABDate){
//                        B++;
//                    }else{
//                        flag = false;
//                    }
//                }else{
//                    B++;
//                }
//            }
//            ABDate = A*10000000+B*1000000+A*100000+B*10000+B*1000+A*100+B*10+A;
//        }
//
//        System.out.println(ABDate);
//    }

//    public static void permutation(int[] nums,int index){
//        if(nums.length == index){
//            for(int i=0;i<nums.length;i++){
//                System.out.print(nums[i]+" ");
//            }
//            System.out.println();
//        }
//        else{
//            for(int i=index;i<nums.length;i++){
//                int swap = nums[i];
//                nums[i] = nums[index];
//                nums[index] = swap;
//
//                permutation(nums,index+1);
//
//                swap = nums[index];
//                nums[index] =nums[i];
//                nums[i] = swap;
//            }
//        }
//    }
//    public static void main(String[] args) {
//        int[] nums = {1,2,3};
//        permutation(nums,0);
//
//    }


    // 修改数组
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int N = input.nextInt();
//        int nums[] = new int[N];
//        for(int i=0;i<N;i++){
//            nums[i] = input.nextInt();
//        }
//        boolean flag = true;
//        int m=0;
//        for(int i=0;i<N;i++){
//            while(flag){
//                for(int j=0;j<i;j++){
//                    if(nums[i] == nums[j]){
//                        nums[i]++;
//                        m = 1;
//                    }
//                }
//                if(m == 0){
//                    flag = false;
//                }
//                m = 0;
//            }
//            flag = true;
//        }
//        for(int i=0;i<N;i++){
//            System.out.println(nums[i]);
//        }
//    }


    //蓝肽子序列
    public static void putList(List list, String lantai){
        String strPro = "";
        for(int i=0;i<lantai.length();i++){
            if((lantai.charAt(i) >= 'A' && lantai.charAt(i) <= 'Z')){
                if(i!=0){
                    list.add(strPro);
                }
                strPro = String.valueOf(lantai.charAt(i));
            }else{
                strPro += String.valueOf(lantai.charAt(i));
            }
        }
        list.add(strPro);
    }
    public static int max(int a, int b){
        return a>=b ? a : b;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String lantai1 = input.nextLine();
        String lantai2 = input.nextLine();
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();

        putList(list1,lantai1);
        putList(list2,lantai2);

        int [][] dp = new int[list1.size()+1][list2.size()+1];
        for(int i=1;i<=list1.size();i++){
            for(int j=1;j<=list2.size();j++){
                if(list1.get(i-1).equals(list2.get(j-1))){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[list1.size()][list2.size()]);

    }

}
