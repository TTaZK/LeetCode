package leetcode_with_name;

import java.util.Arrays;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root, right, left;
        int rootValue = 0;
        int leftLen = 0;
        // 根结点
        if (postorder.length > 0) rootValue = postorder[postorder.length - 1];
        // 叶子节点
        if (postorder.length == 0 || inorder.length == 0) return null;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                leftLen = i;
                break;
            }
        }
        int[] inorder_1 = Arrays.copyOfRange(inorder, 0, leftLen);
        int[] inorder_2 = Arrays.copyOfRange(inorder, leftLen + 1, inorder.length);
        int[] postorder_1 = Arrays.copyOfRange(postorder, 0, leftLen);
        int[] postorder_2 = Arrays.copyOfRange(postorder, leftLen, postorder.length - 1);

        root = new TreeNode(rootValue);
        left = buildTree(inorder_1, postorder_1);
        right = buildTree(inorder_2, postorder_2);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        int[] post = new int[]{9, 15, 7, 20, 3};
        int[] in = new int[]{9, 3, 15, 20, 7};
        buildTree(in, post);
    }
}
