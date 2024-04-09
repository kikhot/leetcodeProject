package com.xtu;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LC239 {


    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        LinkedList<Integer> resultList = new LinkedList<>();
        for (int i = 1 - k, j = 0; j < nums.length; i++, j++) {
            if (i > 0 && queue.getFirst() == nums[i - 1]) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && queue.getLast() < nums[j]) {
                queue.removeLast();
            }
            queue.addLast(nums[j]);
            if (i >= 0) {
                resultList.add(queue.getFirst());
            }
        }
        return resultList.stream().mapToInt(o -> o).toArray();
    }

}
