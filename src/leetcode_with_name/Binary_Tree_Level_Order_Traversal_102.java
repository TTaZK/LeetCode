package leetcode_with_name;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_102 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> child = new ArrayDeque<>();
        // 用于存储
        Queue<TreeNode> parent = new ArrayDeque<>();
        if (root == null) return res;
        parent.add(root);
        while (!parent.isEmpty() || !child.isEmpty()) {
            List<Integer> p = new ArrayList<>();
            while (!parent.isEmpty()) {
                TreeNode head = parent.poll();
                if (head.left != null) {
                    child.offer(head.left);
                }
                if (head.right != null) {
                    child.offer(head.right);
                }
                p.add(head.val);
            }
            while (!child.isEmpty()) {
                // 将 child 中的节点移到 parent 中
                parent.add(child.poll());
            }
            res.add(new ArrayList<>(p));
            p.clear();
        }
        return res;
    }
}
