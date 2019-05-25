import java.util.ArrayList;
import java.util.List;

public class No17 {
    // 对两个数组进行排列组合
    // 使用队列（FIFO），实现思路类似于图的深度优先遍历
    // 先将第一个数组的全部元素依次进入队列，然后弹出队首，用队首依次与数组b的每个元素相组合
    // 将组合结果置入队尾
    // 如果数组a的全部元素都已经从队列中弹出并组合，那么排列结束
    // tips：队列中存储的元素长度依次是：1(只有数组a中的元素)；1或2(部分数组a的元素，部分数组a元素与b元素的组合)；2（只有数组a,b元素的组合）
    // 最好使用Queue（方便理解）
    public static List<String> combination(int[] a, int[] b) {
        // 用于存储组合结果
        List<String> ans = new ArrayList<>();
        for (int i : a) {
            ans.add(i + "");
        }
        while (ans.get(0).length() == 1) {
            // 此时列表中还单独存在数组a的元素
            String head = ans.remove(0);
            for (int j : b) {
                // 将数组a中的元素与b中的元素相组合并入队
                ans.add(head + j);
            }
        }
        return ans;
    }

    public static List<String> combination1(int[][] array) {
        // 用于存储组合结果
        List<String> ans = new ArrayList<>();
        // 添加一个空元素（长度为0），方便与后续保持一致
        ans.add("");
        for (int i = 0; i < array.length; i++) {
            // 不断弹出队首，直到队首长度大于于当前数组索引值
            // 将队首元素与当前数组的元素依次进行组合并入队
            // 对于当前数组，如果队列中存在前一个数组的排列组合，那么需要将队列中的组合依次移除并与当前数组的元素进行排列组合
            while (ans.get(0).length() == i) {
                String head = ans.remove(0);
                int[] b = array[i];
                for (int j : b) {
                    ans.add(head + j);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> result = combination(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        List<String> result1 = combination1(new int[][]{{
                1, 2, 3
        }, {
                4, 5, 6
        }, {
                7, 8, 9
        }});
        System.out.println(result1.size());
        for (String s : result1) {
            System.out.print(s + "  ");
        }
    }
}
