package com.xtu;

public class LC2698 {
    public int punishmentNumber(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (checkTrue(i * i, i))
                result += i * i;
        }
        return result;
    }

    public boolean checkTrue(int n, int x) {
        if (n == x) {
            return true;
        }
        int div = 10;
        while (n % div <= x && n >= div) {
            if (checkTrue(n / div, x - n % div)) {
                return true;
            }
            div *= 10;
        }
        return false;
    }
}
