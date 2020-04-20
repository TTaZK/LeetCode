package leetcode_with_name;

import java.util.Arrays;

public class Convert_Sorted_Array_to_Binary_Search_Tree_108 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 数组有序
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length <= 0) return null;
        // if (nums.length == 1) return new TreeNode(nums[0]);
        // 中间元素作为根结点
        int mid = nums[nums.length / 2];
        TreeNode root = new TreeNode(mid);
        // from include, to not include
        int[] leftSub = Arrays.copyOfRange(nums, 0, nums.length / 2);
        int[] rightSub = Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length);

        TreeNode left = sortedArrayToBST(leftSub);
        TreeNode right = sortedArrayToBST(rightSub);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        sortedArrayToBST(array);
    }
}
