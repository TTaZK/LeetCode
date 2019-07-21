package leetcode_with_name;

import java.util.ArrayList;
import java.util.List;

public class TetsAllSort {

    public static List<List<Integer>> test(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        test(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    public static void test(int[] nums, int level, List<List<Integer>> ans, List<Integer> cur) {
        if (level >= nums.length) {
            ans.add(new ArrayList<>(cur));
        } else {
            for (int i = level; i < nums.length; i++) {
                cur.add(nums[i]);
                swap(nums, level, i);
                test(nums, level + 1, ans, cur);
                cur.remove(cur.size() - 1);
                swap(nums, level, i);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = test(new int[]{1, 2, 3});
        for (List<Integer> list : ans) {
            for (int v : list) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
