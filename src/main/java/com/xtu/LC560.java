package com.xtu;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用前缀和方法
 */
public class LC560 {
    public static int subarraySum(int[] nums, int k) {
        // key为preSum值，value为preSum出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int result = 0;
        map.put(preSum, 1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int flag = preSum - k;
            if (map.containsKey(flag)) {
                result += map.get(flag);
            }
            map.merge(preSum, 1, Integer::sum);
        }
        return result;
    }

    public static void main(String[] args) {
        subarraySum(new int[]{1, 1, 1}, 2);
    }
}
