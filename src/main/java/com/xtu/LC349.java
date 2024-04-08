package com.xtu;

import java.util.HashSet;
import java.util.Set;

public class LC349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> setNum1 = new HashSet<>();
        Set<Integer> setResult = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            setNum1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (setNum1.contains(nums2[i])) {
                setResult.add(nums2[i]);
            }
        }

        return setResult.stream().mapToInt(o -> o).toArray();
    }
}
