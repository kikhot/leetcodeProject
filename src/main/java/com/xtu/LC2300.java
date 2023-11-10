package com.xtu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC2300 {

    // 最后几个用例超时
//    public int[] successfulPairs(int[] spells, int[] potions, long success) {
//        int[] pairs = new int[spells.length];
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int i = 0; i < spells.length; i++) {
//            int count = 0;
//            if (map.containsKey(spells[i])) {
//                pairs[i] = map.get(spells[i]);
//                continue;
//            }
//            for (int j = 0; j < potions.length; j++) {
//                if ((long) spells[i] * potions[j] >= success) {
//                    count++;
//                }
//            }
//            pairs[i] = count;
//            map.put(spells[i], count);
//        }
//        return pairs;
//    }

    /**
     * 使用二分查找法求解
     *
     * @param spells
     * @param potions
     * @param success
     * @return
     */
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] pairs = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            pairs[i] = potions.length - binarySearch(spells[i], potions, success);
        }
        return pairs;
    }

    public static int binarySearch(int spell, int[] potions, long success) {
        int left = 0;
        int right = potions.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((long) spell * potions[mid] >= success) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16);
    }
}
