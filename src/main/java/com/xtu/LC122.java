package com.xtu;

public class LC122 {

    public int maxProfit(int[] prices) {
        int preMin = prices[0];
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < preMin) {
                preMin = prices[i];
            } else {
                totalProfit += prices[i] - preMin;
                preMin = prices[i];
            }
        }
        return totalProfit;
    }

}
