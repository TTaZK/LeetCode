package leetcode_with_name;

import java.util.Arrays;

public class Longest_Consecutive_Sequence_128 {
    // 未排序数组中最长连续序列
    // 要求时间复杂度为 O(n)
    // 可以尝试采用空间换时间的做法：先找到数组中的最大元素 max，之后构造长度为 max 的数组m
    // 遍历nums数组，将每个元素value置入m数组中index为value的位置处
    // 之后再遍历m数组
    // 还有钟算法是先对nums进行排序，之后遍历；但是时间复杂度为O(nlogn)// 但是会存在相同的元素
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 0) return 0;
        Arrays.sort(nums);
        int l = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] - nums[i - 1] == 1) {
                l++;
            } else {
                max = Math.max(max, l);
                l = 1;
            }
        }
        return Math.max(max, l);
    }
}
