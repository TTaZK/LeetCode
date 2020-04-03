package leetcode_with_name;

public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309 {
    // 题目中说明：当前天可以什么都不操作；不能在买进之前进行卖出操作；卖出之后需要有一天的冷冻期
    public int maxProfit(int[] prices) {
        // buy[i] 表示截止第i天，最后一次操作是买进的最大收益
        // sell[i] 表示截止第i天，最后一次操作是卖出的最大收益
        // 需要说明下，buy[i] & sell[i] 并不代表第i天进行买进或卖出操作
        // 可以在第i天之前进行最后一次买进/卖出操作
        // buy[i] = max{buy[i-1],sell[i-2]-prices[i]} --->第i天不买进 vs 第i天买进
        // sell[i] = max{sell[i-1], buy[i-1]+prices[i]} ---> 第i天不卖出 vs 第i天卖出
        // not ac
        if (prices.length == 0) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = -Math.min(prices[0], prices[1]);
        sell[0] = 0;// 在买进之前不能进行卖出，所以初始为0
        sell[1] = Math.max(0, prices[0] - prices[1]);
        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }
}
