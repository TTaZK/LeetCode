package leetcode_with_name;

import java.util.Arrays;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root, right, left;
        int rootValue = 0;
        int leftLen = 0;
        // 根结点
        if (preorder.length > 0) rootValue = preorder[0];
        // 叶子节点
        if (preorder.length == 0 || inorder.length == 0) return null;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                leftLen = i;
                break;
            }
        }
        int[] inorder_1 = Arrays.copyOfRange(inorder, 0, leftLen);
        int[] inorder_2 = Arrays.copyOfRange(inorder, leftLen + 1, inorder.length);
        int[] preorder_1 = Arrays.copyOfRange(preorder, 1, leftLen + 1);
        int[] preorder_2 = Arrays.copyOfRange(preorder, leftLen + 1, preorder.length);

        root = new TreeNode(rootValue);
        left = buildTree(preorder_1, inorder_1);
        right = buildTree(preorder_2, inorder_2);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] in = new int[]{9, 3, 15, 20, 7};
        buildTree(pre, in);
    }
}
