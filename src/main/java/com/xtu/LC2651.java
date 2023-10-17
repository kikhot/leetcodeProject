package com.xtu;

public class LC2651 {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime){
        return (arrivalTime + delayedTime) % 24;
    }
}
