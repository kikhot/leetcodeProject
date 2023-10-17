package com.xtu;

public class LC367 {
    public boolean isPerfectSquare(int num){
        int left = 1;
        int right = num;
        while(left <= right){
            int mid = (left+right)>>1;
            if(mid > (double)num/mid){
                right = mid - 1;
            }else if(mid < (double)num/mid){
                left = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
