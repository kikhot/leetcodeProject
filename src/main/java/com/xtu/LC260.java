package com.xtu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LC260 {
    public int[] singleNumber(int[] nums){
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        Object[] result = set.toArray();
        return new int[]{(int)result[0], (int)result[1]};
    }
}
