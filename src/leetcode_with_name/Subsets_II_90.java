package leetcode_with_name;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets_II_90 {
    // 利用回溯法求出所有的子集，在计算所有的子集的时候可以按照顺序插入
    // 然后对子集进行过滤
    // ac
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        backTrack(nums, 0, new ArrayList<>(), set);
        for (List<Integer> list : set) {
            ans.add(list);
        }
        return ans;
    }

    public static void backTrack(int[] nums, int curLevel, List<Integer> cur, Set<List<Integer>> res) {
        if (curLevel >= nums.length) {
            res.add(new ArrayList<>(cur));
        } else {
            int value = nums[curLevel];
            // 不放入当前列表
            backTrack(nums, curLevel + 1, new ArrayList<>(cur), res);
            // 放入当前列表
            addValue(cur, value);
//            cur.add(value);
            backTrack(nums, curLevel + 1, new ArrayList<>(cur), res);
        }
    }

    // 如果非要进行优化的话，该部分还可以用二分查找
    public static void addValue(List<Integer> cur, Integer value) {
        for (int i = 0; i < cur.size(); i++) {
            if (value <= cur.get(i)) {
                cur.add(i, value);
                return;
            }
        }
        // 列表为空/当前元素比列表中的所有元素都大
        cur.add(value);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 3};
        subsetsWithDup(a);
    }
}
