package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No77 {
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0 || n < k) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        int[] values = new int[n];
        for (int i = 1; i <= n; i++) {
            values[i - 1] = i;
        }
        List<Integer> cur = new ArrayList<>();
        backTrack(values, k, 0, cur, result);
        return result;
    }

    /**
     * 回溯求解
     *
     * @param values 每层可能的取值
     * @param k      解空间树的层数
     * @param level  当前层数
     * @param cur    在当前层数时的路径
     * @param result 返回结果集合
     * @return
     */
    public List<List<Integer>> backTrack(int[] values, int k, int level, List<Integer> cur,
                                         List<List<Integer>> result) {
        if (level >= k) {
            // 如果直接add(cur)，那么当回溯过程中cur.remove()元素时，会导致result中的元素也跟着改变
            // 因为都是指向cur
            result.add(new ArrayList<>(cur));
        } else {
            for (int i = 0; i < values.length; i++) {
                // 当前路径添加该层可能的取值
                int value = values[i];
                int[] temp = values;
                cur.add(value);
                // 下一层节点只能取比当前取值大的值
                // 剪枝
                values = Arrays.copyOfRange(values, i + 1, values.length);
                backTrack(values, k, level + 1, cur, result);
                // 恢复原来的路径前缀，以便下次迭代
                cur.remove(cur.size() - 1);
                values = temp;
            }
        }
        return result;
    }
}
