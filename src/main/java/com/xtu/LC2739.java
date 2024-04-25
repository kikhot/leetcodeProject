package com.xtu;

public class LC2739 {

    public int distanceTraveled(int mainTank, int additionalTank) {
        int count = 0;
        while (mainTank > 0) {
            mainTank--;
            count++;
            if (count % 5 == 0 && additionalTank > 0) {
                mainTank++;
                additionalTank--;
            }
        }
        return count * 10;
    }
}
