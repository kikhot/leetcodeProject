package com.xtu;

import java.util.Arrays;
import java.util.HashMap;

public class LC100111 {
    public static int findKOr(int[] nums, int k) {
        // 如果k为nums数组的长度，则直接将nums中的所有数进行AND
        int result = 0;
        if (nums.length == k) {
            result = nums[0];
            for (int i = 1; i < nums.length; i++) {
                result &= nums[i];
            }
            return result;
        }

        //如果 k 为 1，则只需要nums中的一个位为 1 即可
        if (k == 1) {
            result = nums[0];
            for (int i = 1; i < nums.length; i++) {
                result |= nums[i];
            }
            return result;
        }

        //遍历nums数组中所有的数的第 i 位是否为 1 ，如果为1的数大于等于k，则满足要求
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            int i = 0;
            while ((nums[j] >> i) > 0) {
                if (((long) Math.pow(2, i) & nums[j]) == Math.pow(2, i)) {
                    map.merge(i, 1, Integer::sum);
                }
                i++;
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) >= k) {
                result += Math.pow(2, key);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findKOr(new int[]{925011496, 103855710, 1584980217, 1804943441, 904176743, 71227402, 658339386, 1949490684, 394057351, 1504638274, 936036729, 516283059, 995417756, 1370320334, 1501991237, 578607899, 981063549, 1950398619, 780236107, 258555692, 2055224506, 521917008, 1643308943, 522924296, 1115988653, 136177651, 2112081121, 1411190147, 1059197244, 1476196073, 1563551833, 477789887, 1901104327, 752532861, 824056222}, 16));
    }
}
