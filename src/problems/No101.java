package problems;

public class No101 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 判断一棵二叉树是不是对称的
    // 与之前的题目(100)：判断两棵二叉树是否相等类似
    // 如果直接套用之前的方式，对于[1,2,2,3,4,4,3]会出错
    @Deprecated
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        if (root.left.val != root.right.val) return false;
        return isSymmetric(root.left) && isSymmetric(root.right);
    }

    // 可以把左子树或右子树进行对称变换，如果变换之后两个子树相等，则原树对称
    // 也可以换种思路：一个对称树，它的左子树与右子树对称
    public boolean isSymmetric1(TreeNode root) {
        return isMirror(root, root);
    }

    // 判断两个树是否是镜像
    // 两个树的根节点相同，并且A树的左子树与B树的右子树相同，B树的右子树与A树的左子树相同
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

}
