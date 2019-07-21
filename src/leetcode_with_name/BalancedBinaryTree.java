package leetcode_with_name;

public class BalancedBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (isBalanced(root.left) && isBalanced(root.right)) {
            int left = depth(root.left);
            int right = depth(root.right);
            return Math.abs(left - right) <= 1 ? true : false;
        }
        return false;
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left), right = depth(root.right);
        return left > right ? left + 1 : right + 1;
    }
}
