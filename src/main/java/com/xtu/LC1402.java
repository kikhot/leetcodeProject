package com.xtu;

import java.util.Arrays;

public class LC1402 {
    public int maxSatisfaction(int[] satisfaction) {
        //首先对数组按照从小到大排序
        Arrays.sort(satisfaction);
        //从后往前遍历，首先使用sum表示遍历当前数之前所选的所有数之和，如果当前数currentNum+sum大于0，表示当前数可以加入
        int sum = 0;
        int result = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            if(satisfaction[i] + sum >0){
                sum += satisfaction[i];
                result += sum;
            }
        }
        return result;
    }
}
