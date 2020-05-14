package leetcode_with_name;

public class Best_Time_to_Buy_and_Sell_Stock_121 {
    // 类似于最长子串的和
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 0) return 0;
        int[] subs = new int[n];
        subs[0] = 0;
        for (int i = 1; i < n; i++) {
            subs[i] = prices[i] - prices[i - 1];
        }
        int curMax = 0;
        int sofarMax = 0;
        for (int i = 0; i < n; i++) {
            curMax = Math.max(subs[i], curMax + subs[i]);
            sofarMax = Math.max(sofarMax, curMax);
        }
        return sofarMax <= 0 ? 0 : sofarMax;
    }
}
