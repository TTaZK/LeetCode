package leetcode_with_name;

public class PathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 判断从根节点到叶节点是否存在一条和为sum的路径
    // 最简单的方式是对该树的所有路径找出来，之后进行求和比较
    // 或者利用回溯法，终止条件是当前路径和大于sum
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null || root.val > sum) return false;
        return hasPathSum(root, sum, 0);
    }

    public static boolean hasPathSum(TreeNode root, int sum, int curSum) {
        if (root == null || curSum > sum) return false;
        if (root.left == null && root.right == null && curSum + root.val == sum) return true;
        return hasPathSum(root.left, sum, curSum + root.val) ||
                hasPathSum(root.right, sum, curSum + root.val);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(2);
        node1.left = node2;
        node1.right = null;
        node2.left = node3;
        node2.right = null;
        node3.left = node4;
        node3.right = node5;
        hasPathSum(node1, 22);

    }
}
