package leetcode_with_name;

import java.util.*;

public class CombinationSum {
    // 看到题目首先想到用回溯法（排列树）
    // 因为数组中的数可以重复选择，因此在构造解空间树时，每一次可以选择的值都是全部值
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> set = combinationSum(candidates, target, new HashSet<List<Integer>>(), new ArrayList<>());
        List<List<Integer>> ans = new ArrayList<>();
        Iterator<List<Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            ans.add(iterator.next());
        }
        return ans;
    }

    // 解空间树返回的条件是当前和大于目标值
    public Set<List<Integer>> combinationSum(int[] candidates, int target, Set<List<Integer>> ans, List<Integer> cur) {
        int curSum = 0;
        for (int value : cur) {
            curSum += value;
        }
        if (curSum > target) {
            return null;
        } else if (curSum == target) {
            Object[] arrs = cur.toArray();
            Arrays.sort(arrs);
            List<Integer> temp = new ArrayList<>();
            for (Object v : arrs) {
                temp.add((Integer) v);
            }
            ans.add(temp);
        } else {
            for (int candidate : candidates) {
                cur.add(candidate);
                combinationSum(candidates, target, ans, cur);
                cur.remove(cur.size() - 1);
            }
        }
        return ans;
    }
}
