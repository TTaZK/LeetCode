package leetcode_with_name;

import java.util.*;

public class IncreasingSubsequences {
    // 该题是求给定数组的所有递增子序列
    // 首先想到的是利用回溯法（其实求最长递增子序列也可以用回溯法）
    public static List<List<Integer>> findSubsequences1(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        findSubsequences1(nums, 0, set, new ArrayList<>());
        List<List<Integer>> ans = new ArrayList<>();
        Iterator<List<Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            ans.add(iterator.next());
        }
        return ans;
    }

    // 直接使用全排列的解空间树
    public static void findSubsequences1(int[] nums, int level, Set<List<Integer>> ans, List<Integer> cur) {
        if (level <= nums.length && cur.size() >= 2) {
            for (int i = 0; i < cur.size() - 1; i++) {
                if (cur.get(i) > cur.get(i + 1)) {
                    return;
                }
            }
            ans.add(new ArrayList<>(cur));
        } else if (level > nums.length) {
            return;
        }
        for (int i = level; i < nums.length; i++) {
            cur.add(nums[i]);
            swap(nums, level, i);
            findSubsequences1(nums, level + 1, ans, cur);
            cur.remove(cur.size() - 1);
            swap(nums, level, i);
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 其实使用全排列空间树可能想法不对，那么我们可以使用子集树
    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findSubsequences(nums, 0, ans, new ArrayList<>());
        Set<List<Integer>> set = new HashSet<>(ans);
        ans.clear();
        Iterator<List<Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            ans.add(iterator.next());
        }
        return ans;
    }

    public static void findSubsequences(int[] nums, int level, List<List<Integer>> ans, List<Integer> cur) {
        if (level >= nums.length) {
            if (isInscreasing(cur)) {
                ans.add(cur);
            }
            return;
        }
        findSubsequences(nums, level + 1, ans, new ArrayList<>(cur));
        cur.add(nums[level]);
        findSubsequences(nums, level + 1, ans, new ArrayList<>(cur));
    }

    public static boolean isInscreasing(List<Integer> list) {
        if (list.size() >= 2) {
            int i = 0, n = list.size();
            for (; i < n - 1; i++) {
                if (list.get(i) > list.get(i + 1)) return false;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = findSubsequences(new int[]{4, 1, 2, 3});
        for (List<Integer> list : ans) {
            for (int v : list) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
