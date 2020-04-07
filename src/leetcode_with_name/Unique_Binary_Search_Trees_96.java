package leetcode_with_name;

public class Unique_Binary_Search_Trees_96 {
    // 主要是为了计算出异构二叉搜索树的数目
    // 考虑使用递归：左子树有m个节点，右子树有n个节点 ---> 考虑到需要重复计算子问题，转而采用dp
    // 左子树的异构数目 * 右子树的异构数目 = 全部异构数
    // 类似钢条切割
    public static int numTrees(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        // 左子树的节点数目 from 0 to n-1
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                int left = f[j];
                int right = f[i - 1 - j];
                f[i] += left * right;
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        numTrees(3);
    }
}
