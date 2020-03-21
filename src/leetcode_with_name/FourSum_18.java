package leetcode_with_name;

import java.util.*;

public class FourSum_18 {
    // 回溯法：子集树
    // 对于数据量大的数组，超时了
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        backTrack(nums, target, 0, new ArrayList<>(), set);
        for (List cur : set) {
            res.add(cur);
        }
        return res;
    }

    public static void backTrack(int[] nums, int target, int curLevel, List<Integer> curList, Set<List<Integer>> res) {
        if (curLevel >= nums.length) {
            if (curList.size() == 4 && isConstrant(curList, target) && !isDuplication(res, curList)) res.add(curList);
        } else {
            int curVal = nums[curLevel];
            // 分支剪切
            if (curList.size() <= 3) {
                // 不包含当前节点
                backTrack(nums, target, curLevel + 1, new ArrayList<>(curList), res);
                // 包含当前节点
                curList.add(curVal);
                backTrack(nums, target, curLevel + 1, new ArrayList<>(curList), res);
            } else {
                if (isConstrant(curList, target) && !isDuplication(res, curList)) res.add(curList);
            }
        }
    }

    public static boolean isConstrant(List<Integer> list, int target) {
        int curSum = 0;
        for (Integer num : list) {
            curSum += num;
        }
        if (curSum == target) return true;
        return false;
    }

    public static boolean isDuplication(Set<List<Integer>> set, List<Integer> cur) {
        for (List<Integer> l : set) {
            List<Integer> temp = new ArrayList<>(cur);
            for (int i : l) {
                if (temp.contains(i)) {
                    temp.remove(Integer.valueOf(i));
                }
            }
            if (temp.size() == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        for (List<Integer> cur : res) {
            for (Integer c : cur) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
