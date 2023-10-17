package com.xtu;

public class LC69 {
    public static int mySqrt(int x){
        long left = 1;
        long right = x;
        while(left <= right){
            long mid = (long)(left+right) >> 1;
            if((long)mid*mid > x){
                right = mid - 1;
            }else if((long)mid*mid < x){
                left = mid + 1;
            }else{
                return (int)mid;
            }
        }
        return (int)right;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647));
    }
}
