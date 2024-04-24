package com.xtu;

public class LC1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sumSatis = 0;
        for (int i = 0; i < customers.length; i++) {
            sumSatis += customers[i] * (1 - grumpy[i]);
        }
        if (customers.length < minutes) {
            return sumSatis;
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int result = 0;

        for (; right < minutes; right++) {
            if (grumpy[right] == 1) {
                sum += customers[right];
            }
        }

        result = Math.max(result, sum);

        for (; right < customers.length; right++, left++) {
            sum = sum - grumpy[left] * customers[left] + grumpy[right] * customers[right];
            result = Math.max(result, sum);
        }

        return sumSatis + result;

    }
}
