package com.xtu;

import java.util.*;

public class LC2342 {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int count = 0;
            int tempNum = num;
            while (num != 0) {
                count += num % 10;
                num /= 10;
            }
            if (!map.containsKey(count)) {
                List<Integer> list = new ArrayList<>();
                list.add(tempNum);
                map.put(count, list);
            } else {
                map.get(count).add(tempNum);
            }
        }
        System.out.println(map.toString());
        int maxRes = 0;
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            if (list == null || list.size() < 2)
                continue;
            Collections.sort(list);
            int temp = list.get(list.size() - 1) + list.get(list.size() - 2);
            if (temp > maxRes) {
                maxRes = temp;
            }
        }
        return maxRes == 0 ? -1 : maxRes;
    }
}
