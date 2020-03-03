package leetcode_with_name;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        // f[i]表示到第i家住户为止，所抢劫的最大金额
        int[] f = new int[n + 1];
        if (n <= 0) {
            return 0;
        } else {
            f[0] = 0;
            f[1] = nums[0];
            for (int i = 2; i < n + 1; i++) {
                f[i] = f[i - 1] > f[i - 2] + nums[i - 1] ? f[i - 1] : f[i - 2] + nums[i - 1];
            }
            return f[n];
        }
    }
}
