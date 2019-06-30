public class No104 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 二叉树的最大深度
    // 可以转换为回溯的思路
    public int maxDepth(TreeNode root) {
        // 表示到达最后一层
        if (root == null) return 0;
        // 对可能的取值分别进行讨论
        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);
        return left > right ? left : right;
    }
}
