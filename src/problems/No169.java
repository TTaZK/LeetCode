package problems;

import java.util.Arrays;

public class No169 {
    // 排序法
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if (n <= 0) return 0;
        Arrays.sort(nums);
        return nums[n / 2];
    }

    // 投票法
    public int majorityElement1(int[] nums) {
        int vote = 0, ans = 0;
        for (int cur : nums) {
            if (vote == 0) {
                ans = cur;
            }
            if (ans == cur) {
                vote++;
            } else {
                vote--;
            }
        }
        return ans;
    }
}
