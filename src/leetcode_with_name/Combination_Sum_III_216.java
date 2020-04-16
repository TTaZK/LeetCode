package leetcode_with_name;

import java.util.*;

public class Combination_Sum_III_216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        int[] value = new int[9];
        for (int i = 1; i <= 9; i++) {
            value[i - 1] = i;
        }
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        backTrack(n, k, 0, value, new ArrayList<>(), set);
        for (List list : set) {
            res.add(list);
        }
        return res;
    }

    public static void backTrack(int n, int k, int curLevel, int[] value, List<Integer> cur, Set<List<Integer>> res) {
        if (curLevel >= k) {
            int sum = 0;
            for (int v : cur) {
                sum += v;
            }
            if (sum == n) {
                res.add(new ArrayList<>(cur));
            }
        } else {
            for (int i = curLevel; i < value.length; i++) {
                // 当前取值范围是 curLevel ... length-1
                swap(value, curLevel, i);
                // cur.add(value[curLevel]);
                int index = addValue(cur, value[curLevel]);
                backTrack(n, k, curLevel + 1, value, cur, res);
                // back track
                swap(value, curLevel, i);
                cur.remove(index); // 剔除刚刚添加的元素
            }
        }
    }

    // 将元素有序插入当前列表中
    public static int addValue(List<Integer> cur, Integer value) {
        for (int i = 0; i < cur.size(); i++) {
            if (value <= cur.get(i)) {
                cur.add(i, value);
                return i;
            }
        }
        // 列表为空/当前元素比列表中的所有元素都大
        cur.add(value);
        return cur.size() - 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum3(3, 7);
        for (List list : res) {
            // System.out.println(Collections.to);
        }
    }
}
