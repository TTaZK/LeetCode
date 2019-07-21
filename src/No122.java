public class No122 {
    // 对于之前的买卖股票，需要计算的是某两个位置的差值最大
    // 对于当前题目，由于可以进行多次买卖，因此只要任意两个数的差为正数，就可以进行一次买卖（对于递增的序列，我们可以换一种思考方式
    // ：第一个为正的差值前一个数字开始买进，最后一个为正的差值开始卖出）
    // 该写法通过了测试用例，但是应该需要理清楚思路

    public int maxProfit(int[] prices) {
        int profit = 0, s = 0;
        for (int i = 1; i < prices.length; i++) {
            if ((s = prices[i] - prices[i - 1]) > 0) {
                profit += s;
            }
        }
        return profit;
    }
}
