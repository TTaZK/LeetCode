package leetcode_with_name;

public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_309 {
    // 题目中说明：当前天可以什么都不操作；不能在买进之前进行卖出操作；卖出之后需要有一天的冷冻期
    public static int maxProfit(int[] prices) {
        // buy[i] 表示截止第i天，最后一次交易操作是买进的最大收益
        // sell[i] 表示截止第i天，最后一次交易操作是卖出的最大收益
        // 需要说明下，buy[i] & sell[i] 并不代表第i天进行买进或卖出操作
        // 可以在第i天之前进行最后一次买进/卖出操作
        // buy[i] = max{buy[i-1],sell[i-2]-prices[i]} --->第i天不买进 vs 第i天买进
        // sell[i] = max{sell[i-1], buy[i-1]+prices[i]} ---> 第i天不卖出 vs 第i天卖出
        // not ac
        if (prices.length <= 1) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = -Math.min(prices[0], prices[1]);
        sell[0] = 0;// 在买进之前不能进行卖出，所以初始为0
        sell[1] = Math.max(0, prices[1] - prices[0]);
        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 0, 2};
        maxProfit(array);
    }

    // 1. Define States
    //
    //To represent the decision at index i:
    //
    //buy[i]: Max profit till index i. The series of transaction is ending with a buy.
    //sell[i]: Max profit till index i. The series of transaction is ending with a sell.
    //To clarify:
    //
    //Till index i, the buy / sell action must happen and must be the last action. It may not happen at index i. It may happen at i - 1, i - 2, ... 0.
    //In the end n - 1, return sell[n - 1]. Apparently we cannot finally end up with a buy. In that case, we would rather take a rest at n - 1.
    //For special case no transaction at all, classify it as sell[i], so that in the end, we can still return sell[n - 1]. Thanks @alex153 @kennethliaoke @anshu2.
    //2. Define Recursion
    //
    //buy[i]: To make a decision whether to buy at i, we either take a rest, by just using the old decision at i - 1, or sell at/before i - 2, then buy at i, We cannot sell at i - 1, then buy at i, because of cooldown.
    //sell[i]: To make a decision whether to sell at i, we either take a rest, by just using the old decision at i - 1, or buy at/before i - 1, then sell at i.
    //So we get the following formula:
    //
    //buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
    //sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
    //3. Optimize to O(1) Space
    //
    //DP solution only depending on i - 1 and i - 2 can be optimized using O(1) space.
    //
    //Let b2, b1, b0 represent buy[i - 2], buy[i - 1], buy[i]
    //Let s2, s1, s0 represent sell[i - 2], sell[i - 1], sell[i]
    //Then arrays turn into Fibonacci like recursion:
    //
    //b0 = Math.max(b1, s2 - prices[i]);
    //s0 = Math.max(s1, b1 + prices[i]);
    //4. Write Code in 5 Minutes
    //
    //First we define the initial states at i = 0:
    //
    //We can buy. The max profit at i = 0 ending with a buy is -prices[0].
    //We cannot sell. The max profit at i = 0 ending with a sell is 0.
    //Here is my solution. Hope it helps!
    //
    //public int maxProfit(int[] prices) {
    //    if(prices == null || prices.length <= 1) return 0;
    //
    //    int b0 = -prices[0], b1 = b0;
    //    int s0 = 0, s1 = 0, s2 = 0;
    //
    //    for(int i = 1; i < prices.length; i++) {
    //    	b0 = Math.max(b1, s2 - prices[i]);
    //    	s0 = Math.max(s1, b1 + prices[i]);
    //    	b1 = b0; s2 = s1; s1 = s0;
    //    }
    //    return s0;
    //}
}
