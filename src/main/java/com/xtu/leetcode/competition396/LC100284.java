package com.xtu.leetcode.competition396;

public class LC100284 {

    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        int yuanCount = 0;
        int fuCount = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                    yuanCount++;
                } else {
                    fuCount++;
                }
            } else if ((ch >= '0' && ch <= '9')) {

            } else {
                return false;
            }
        }

        return yuanCount != 0 && fuCount != 0;
    }
}
