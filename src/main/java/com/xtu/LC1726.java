package com.xtu;

import java.util.HashMap;
import java.util.Map;

public class LC1726 {
    public int tupleSameProduct(int[] nums) {
        // 使用一个Map来存储所有两两相等的数的总个数
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                map.merge(sum, 1, (oldValue, newValue) -> oldValue + newValue);
            }
        }
        for (Integer key : map.keySet()) {
            int n = map.get(key);
            result += n * (n - 1) / 2;
        }
        return result << 3;
    }
}
