package leetcode_with_name;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
    // 全排列
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        permute(0, nums, lists);
        return lists;
    }

    /**
     * @param level 用于记录当前层数
     * @param nums  输入数组
     * @param ans   记录返回结果
     * @return
     */
    public List<List<Integer>> permute(int level, int[] nums, List<List<Integer>> ans) {
        int n = nums.length;
        if (level >= n) {
            List<Integer> res = new ArrayList<>();
            for (int num : nums) {
                res.add(num);
            }
            ans.add(res);
        } else {
            for (int i = level; i < n; i++) {
                swap(nums, level, i);
                permute(level + 1, nums, ans);
                swap(nums, level, i);
            }
        }
        return ans;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
