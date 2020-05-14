package leetcode_with_name;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        subSets(nums, current, 0, result);
        return result;
    }

    /**
     *
     * @param nums
     *            数组
     * @param current
     *            当前节点的子集合
     * @param level
     *            当前节点所在的层
     * @param result
     *            子集合结果
     */
    public void subSets(int[] nums, List<Integer> current, int level, List<List<Integer>> result) {
        int length = nums.length;
        if (length == level) {
            // 当前节点为叶节点
            result.add(current);
            return;
        }
        // 如果不新建一个ArrayList的话，每次都用current进行操作，那么当对右子树遍历的结果返回后，
        // current的结果已经变了，会导致最后所有的子集合都一样

        // 不加入当前数值时进行遍历（右子树）
        subSets(nums, new ArrayList<Integer>(current), level + 1, result);
        // 加入当前数值进行遍历（左子树）
        current.add(nums[level]);
        subSets(nums, new ArrayList<Integer>(current), level + 1, result);
    }
}
