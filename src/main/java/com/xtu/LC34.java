package com.xtu;

public class LC34 {
    public static int[] searchRange(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int first = -1;
        int last = -1;
        while(left <= right){
            int mid = (left+right)>>1;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                first = mid;
                right = mid - 1;
            }
        }

        left = 0;
        right = nums.length - 1;
        while(left <= right){
            int mid = (left+right)>>1;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                last = mid;
                left = mid + 1;
            }
        }
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        searchRange(new int[]{5,7,7,8,8,10}, 8);
    }
}
