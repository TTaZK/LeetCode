package leetcode_with_name;

public class Longest_Continuous_Increasing_Subsequence_674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int l = 1;
        int index = 0;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                l++;
            } else {

            }
        }
    }
}
