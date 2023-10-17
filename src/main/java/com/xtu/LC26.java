package com.xtu;

public class LC26 {
    public static int removeDuplicates(int[] nums){
        int slowIndex = 0;
        int fastIndex = 0;
        for(fastIndex = 0;fastIndex < nums.length;fastIndex++){
            if(nums[fastIndex] != nums[slowIndex]){
                nums[++slowIndex] = nums[fastIndex];
            }
        }
        return slowIndex+1;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{1,1,2});
    }
}
