package leetcode_with_name;

public class Longest_Continuous_Increasing_Subsequence_674 {
    // 最长连续递增子序列
    // 要求子序列连续
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int l = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                l++;
            } else {
                max = Math.max(max, l);
                l = 1;
            }
        }
        return max > l ? max : l;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 7};
        findLengthOfLCIS(a);
    }

}
