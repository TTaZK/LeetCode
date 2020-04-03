package leetcode_with_name;

import java.util.Arrays;

public class Shortest_Unsorted_Continuous_Subarray_581 {
    // 最简单的方法，先将数组进行排序，然后比对每个位置上的元素
    public static int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        int[] f = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(f);
        int head = 0;
        int tail = nums.length - 1;
        while (head <= tail) {
            if (nums[head] != f[head]) {
                break;
            }
            head++;
        }
        while (tail >= head) {
            if (nums[tail] != f[tail]) {
                break;
            }
            tail--;
        }
        return tail - head + 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};
        findUnsortedSubarray(a);
    }
}
