package com.xtu;

public class LC27 {
    public int removeElement(int[] nums, int val){
        int slowIndex = 0;
        int fastIndex = 0;
        for(fastIndex=0;fastIndex<nums.length;fastIndex++){
            if(val != nums[fastIndex]){
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }
}
