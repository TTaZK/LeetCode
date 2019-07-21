package leetcode_with_name;

import java.util.Arrays;

public class MaximumProductofThreeNumbers {
    // 可以使用回溯法找出所有长度为3的子序列，对所有乘积进行比较
    // 但是该方法有点类似暴力法
    // 可以先对数组进行排序，如果数组中不存在个数小于等于1的负数，那么取最大的三个数最为结果子序列
    // 如果负数个数大于1，那么需要计算最小的两个负数与最大的正数，之后进行比较
    // 在下面的代码中可以看到，其实就是比较nums[n - 1] * nums[n - 2] * nums[n - 3]与nums[0] * nums[1] * nums[n - 1]
    // 的大小，不需要区分是不是正数还是负数
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int result = 0;
        // 数组中只存在一种符号的数字
        if (nums[0] * nums[n - 1] >= 0) {
            // only positive
            if (nums[0] >= 0) {
                result = nums[n - 1] * nums[n - 2] * nums[n - 3];
            } else {
                // only negative
                result = nums[0] * nums[1] * nums[n - 1];
            }
        } else {
            // 数组中存在正数和负数
            int left = nums[0] * nums[1] * nums[n - 1];
            int right = nums[n - 1] * nums[n - 2] * nums[n - 3];
            result = left > right ? left : right;
        }
        return result;
    }
}
