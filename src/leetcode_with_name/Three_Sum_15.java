package leetcode_with_name;

import java.util.*;

public class Three_Sum_15 {
    // before
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<List<Integer>> temp = new HashSet<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        // 每次循环时，固定左指针，让中间指针与右指针相互靠拢
        for (int left = 0; left < nums.length - 2; left++) {
            int mid = left + 1;
            int right = nums.length - 1;
            while (mid < right) {
                List<Integer> list = new ArrayList<Integer>();
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum == 0) {
                    list.add(nums[left]);
                    list.add(nums[mid]);
                    list.add(nums[right]);
                    temp.add(list);
                    mid++;
                    right--;
                } else if (sum < 0) {
                    // 中间指针右移
                    mid++;
                } else if (sum > 0) {
                    // 右指针左移
                    right--;
                }
            }
        }
        for (List<Integer> list : temp) {
            result.add(list);
        }
        return result;
    }

    // rewrite
    // 之前使用三指针，目前倾向于使用回溯法
    // 超时了。。
    // 考虑先对原数组进行排序，这样当进行元素添加的时候就不需要单独保证元素按序插入
    // 还是超时
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        if (nums.length < 3) return ans;
        Arrays.sort(nums);
        backTrack(nums, 0, new ArrayList<>(), set);
        Iterator<List<Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            ans.add(iterator.next());
        }
        return ans;
    }

    public void backTrack(int[] nums, int curLevel, List<Integer> curList, Set<List<Integer>> ans) {
        if (curLevel >= nums.length) {
            if (curList.size() == 3 && curList.get(0) + curList.get(1) + curList.get(2) == 0) {
                ans.add(curList);
            }
        } else {
            if (curList.size() > 3) return;
            // not add curValue
            backTrack(nums, curLevel + 1, new ArrayList<>(curList), ans);
            // add curValue
            // 为了防止最终的结果集中存在元素相同的list, 在添加元素时采用有序添加
            curList.add(nums[curLevel]);
            // addValue(curList, nums[curLevel]);
            backTrack(nums, curLevel + 1, new ArrayList<>(curList), ans);
        }
    }

    private void addValue(List<Integer> cur, int value) {
        // 可以采用二分查找进行优化
        for (int i = 0; i < cur.size(); i++) {
            if (value <= cur.get(i)) {
                cur.add(i, value);
                return;
            }
        }
        // 列表为空/当前元素比列表中的所有元素都大
        cur.add(value);
    }
}
