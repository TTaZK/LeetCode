package leetcode_with_name;

public class ValidateBinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 根节点比左子树大，比右子树小
    // 该写法有问题，只是判断在某一个子树中符合二叉搜索树，但是不能从整体判断（该方法使用的是自底向上）
    // 应该使用自顶向下
    public boolean isValidBST_1(TreeNode root) {
        if (root == null) return true;
        if (isValidBST(root.left) && isValidBST(root.right)) {
            if (root.left != null && root.val <= root.left.val) return false;
            if (root.right != null && root.val >= root.right.val) return false;
            return true;
        }
        return false;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // min表示子树节点的最小值，max表示子树节点的最大值
    // 比如左子树的节点一定要比根节点小，右子树的节点一定要比根节点大
    public boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null) return true;
        // 左子树应该小于的值
        if (root.val <= min) return false;
        // 右子树应该大于的值
        if (root.val >= max) return false;
        // 在进行往下一层递归的过程中，已经隐式地更新了最小值最大值
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

}
