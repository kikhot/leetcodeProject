package com.xtu;

public class LC2520 {
    public int countDigits(int num) {
        int result = 0;
        int tempNum = num;
        while (tempNum != 0) {
            int val = tempNum % 10;
            if (num % val == 0)
                result++;
            tempNum = tempNum / 10;
        }
        return result;
    }
}
