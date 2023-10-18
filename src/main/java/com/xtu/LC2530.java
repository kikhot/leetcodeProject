package com.xtu;


import java.util.Arrays;
import java.util.PriorityQueue;

public class LC2530 {
    public long maxKelments(int[] nums, int k) {
        long result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            Integer poll = queue.poll();
            result += poll;
            poll = (int) Math.ceil((double) poll / 3.0);
            queue.add(poll);

        }
        return result;
    }
}
