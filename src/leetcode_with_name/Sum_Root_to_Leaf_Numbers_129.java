package leetcode_with_name;

public class Sum_Root_to_Leaf_Numbers_129 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumNumbers(root, 0);
    }

    public static int sumNumbers(TreeNode root, int preSum) {
        if (root == null) return 0;
        int v = preSum * 10 + root.val;
        if (root.left == null && root.right == null) return v;
        int left = sumNumbers(root.left, v);
        int right = sumNumbers(root.right, v);
        return left + right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(sumNumbers(root));
    }
}
