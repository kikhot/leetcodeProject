package com.xtu;

import java.util.HashSet;
import java.util.Set;

public class LC2605 {
    public int minNumber(int[] nums1, int[] nums2){
        if(same(nums1, nums2) != -1){
            return same(nums1, nums2);
        }
        int minNums1 = nums1[0];
        int minNums2 = nums2[0];
        for (int i = 0; i < nums1.length; i++) {
            minNums1 = Math.min(minNums1, nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            minNums2 = Math.min(minNums2, nums2[i]);
        }
        return 10*Math.min(minNums1,minNums2)+Math.max(minNums1,minNums2);
    }

    public int same(int[] nums1, int[] nums2){
        Set<Integer> set = new HashSet<>();
        int minSameNum = 10;
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                minSameNum = minSameNum > nums2[i] ? nums2[i] : minSameNum;
            }
        }
        return minSameNum==10 ? -1 : minSameNum;
    }
}
