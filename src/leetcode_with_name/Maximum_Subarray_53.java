package leetcode_with_name;

public class Maximum_Subarray_53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n <= 0) {
            return 0;
        }
        int[] sum = new int[n];
        sum[0] = nums[0];
        int max = sum[0];
        for (int i = 1; i < n; i++) {
            if (sum[i - 1] < 0) {
                sum[i] = nums[i];
            } else {
                sum[i] = nums[i] + sum[i - 1];
            }
            max = max > sum[i] ? max : sum[i];
        }
        return max;
    }
}
