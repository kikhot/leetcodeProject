package com.xtu;

import java.util.HashSet;

public class LC202 {
    public boolean isHappy(int n) {
        HashSet<Integer> setNum = new HashSet<>();
        setNum.add(n);
        while (true) {
            int sum = numIsHappy(n);
            if (sum == 1) {
                return true;
            } else {
                if (setNum.contains(sum)) {
                    return false;
                } else {
                    setNum.add(sum);
                    n = sum;
                }
            }
        }
    }


    public int numIsHappy(int num) {
        int sum = 0;
        while (num > 0) {
            int x = num % 10;
            sum += Math.pow(x, 2);
            num = num / 10;
        }
        return sum;
    }
}
