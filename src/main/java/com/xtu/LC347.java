package com.xtu;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (int key : map.keySet()) {
            if (queue.size() >= k) {
                if (queue.peek()[1] < map.get(key)) {
                    queue.poll();
                    queue.add(new int[]{key, map.get(key)});
                }
            } else {
                queue.add(new int[]{key, map.get(key)});
            }
        }
        int[] resultNum = new int[k];
        for (int i = 0; i < k; i++) {
            resultNum[i] = queue.poll()[0];
        }
        return resultNum;
    }

}
