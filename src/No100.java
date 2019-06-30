
public class No100 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 判断两棵树是否相等
    // 我的想法是对这两棵树进行遍历，如果在遍历过程中出现节点不一致的情况，则树相等
    // 该做法有问题，如果两棵树的遍历结果一致，但是树的结构可能不一致
    // 看了别人的答案，采用递归
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }


}
