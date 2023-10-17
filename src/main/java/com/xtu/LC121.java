package com.xtu;

public class LC121 {

    public int maxProfit(int[] prices) {
        int result = 0; //最终结果
        // 遍历数组，选出当前最低的价格currentMinPrice和最大的利润maxProfit,如果后面有新的最低价格则替换，
        // 如果（当前价格-最低价格）大于maxProfit则将maxProfit改变
        int currentMinPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            currentMinPrice = Math.min(prices[i], currentMinPrice);
            maxProfit = Math.max(prices[i] - currentMinPrice, maxProfit);
        }
        return maxProfit;
    }

}
