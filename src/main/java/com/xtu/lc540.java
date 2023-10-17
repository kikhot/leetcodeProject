package com.xtu;


/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：46.8 MB, 在所有 Java 提交中击败了16.07%的用户
 */
public class lc540 {

    public static int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid = (low+high)/2;
        while(low < high){
            if(mid%2 == 0){
                if(nums[mid] == nums[mid+1]){
                    low=mid+1;
                }else{
                    high=mid;
                }
            }
            else{
                if(nums[mid] == nums[mid-1]){
                    low=mid+1;
                }
                else{
                    high=mid;
                }
            }
            mid = (low+high)/2;
        }

        return nums[mid];
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }

}
