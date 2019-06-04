import java.util.ArrayList;
import java.util.List;

public class No46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        permute(0, nums, lists);
        return lists;
    }

    /**
     * 由第level层向下扩展
     *
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
                // 当前层可能的取值范围为:nums[level]...nums[n-1]
                // 从根节点到当前层的路径值为:nums[0],nums[1]...nums[level]
                swap(nums, level, i);
                // 在当前层取值为nums[i]的情况下计算下一层的取值
                permute(level + 1, nums, ans);
                // 恢复当前层的原始值
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
