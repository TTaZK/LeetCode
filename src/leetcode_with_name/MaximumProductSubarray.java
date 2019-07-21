package leetcode_with_name;

public class MaximumProductSubarray {
    // Loop through the array, each time remember the max and min value for the previous product,
    // the most important thing is to update the max and min value:
    // we have to compare among max * A[i], min * A[i] as well as A[i],
    // since this is product, a negative * negative could be positive.
    // 记录最小值的目的是为了记录前面序列中存在绝对值很大的负数
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = nums[0];
        int max = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = min;
            min = Math.min(Math.min(min * nums[i], max * nums[i]), nums[i]);
            max = Math.max(Math.max(temp * nums[i], max * nums[i]), nums[i]);
            if (max > result) result = max;
        }
        return result;
    }

    public static void main(String[] args) {
        maxProduct(new int[]{2, 3, -2, 4});
    }
}
