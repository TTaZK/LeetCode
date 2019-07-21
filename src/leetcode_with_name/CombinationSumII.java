package leetcode_with_name;

import java.util.*;

public class CombinationSumII {
    // 与第39题类似，也是从数组中选取一些数，使得这些数的和等于目标值，与第39题不同的是，元素不允许多次使用
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        combinationSum2(candidates, target, set, new ArrayList<>(), 0);
        List<List<Integer>> ans = new ArrayList<>();
        Iterator<List<Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            ans.add(iterator.next());
        }
        return ans;
    }

    public void combinationSum2(int[] candidates, int target, Set<List<Integer>> ans, List<Integer> cur, int level) {
        int curSum = 0;
        for (int value : cur) {
            curSum += value;
        }
        if (curSum == target) {
            Object[] arrs = cur.toArray();
            Arrays.sort(arrs);
            List<Integer> temp = new ArrayList<>();
            for (Object v : arrs) {
                temp.add((Integer) v);
            }
            ans.add(temp);
            return;
        }
        if (level >= candidates.length) return;
        // 如果采用全排列的话，如果第一层取10，第二层取1；第一层取1，第二层取10，其实两个是一样的
        // 该写法错误，因为candidates数组元素位置不变，可能存在第一层选取了第二个位置的元素，那么在第二层还是有可能选择同一个元素
        // 所以在选取元素之后，应该将数组的位置进行调整，不然的话，对于同一层的不同分支，可能取得的值都是相同的
        for (int i = level; i < candidates.length; i++) {
            cur.add(candidates[i]);
            swap(candidates, level, i);
            combinationSum2(candidates, target, ans, cur, level + 1);
            cur.remove(cur.size() - 1);
            swap(candidates, level, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**网上的写法
     * public List<List<Integer>> combinationSum2(int[] cand, int target) {
     *     Arrays.sort(cand);
     *     List<List<Integer>> res = new ArrayList<List<Integer>>();
     *     List<Integer> path = new ArrayList<Integer>();
     *     dfs_com(cand, 0, target, path, res);
     *     return res;
     * }
     * void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
     *     if (target == 0) {
     *         res.add(new ArrayList(path));
     *         return ;
     *     }
     *     if (target < 0) return;
     *     for (int i = cur; i < cand.length; i++){
     *         if (i > cur && cand[i] == cand[i-1]) continue;
     *         path.add(path.size(), cand[i]);
     *         dfs_com(cand, i+1, target - cand[i], path, res);
     *         path.remove(path.size()-1);
     *     }
     */
}
