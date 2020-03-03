package leetcode_with_name;

import java.util.Arrays;

public class HouseRobberII {
    // 有一种暴力法是先利用回溯法求出所有可能出现的子序列；对这些子序列的和进行比较，返回最大的值
    // 因为数组组成一个环，则数组的首部与尾部只能抢劫其中一个，那么可以考虑抢劫前0--n-1个住户，抢劫1--n个住户这两种情况
    // 取最大值
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0;
        return Math.max(robWithoutCircle(Arrays.copyOfRange(nums, 0, nums.length - 1)), robWithoutCircle(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    // f[i]表示在第i家住户时抢劫的最大金额
    public int robWithoutCircle(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] f = new int[nums.length + 1];
        f[0] = 0;
        f[1] = nums[0];
        for (int i = 2; i < nums.length + 1; i++) {
            f[i] = f[i - 1] > f[i - 2] + nums[i - 1] ? f[i - 1] : f[i - 2] + nums[i - 1];
        }
        return f[nums.length];
    }
}
