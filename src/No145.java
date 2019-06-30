import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class No145 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 非递归后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVist = root;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 查看当前栈顶元素
            root = stack.peek();
            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (root.right == null || root.right == lastVist) {
                ans.add(root.val);
                lastVist = root;
                stack.pop();
                root = null;
            } else {
                // 继续遍历右子树
                root = root.right;
            }
        }
        return ans;
    }

    // 非递归后序遍历
    // 与先序遍历相反：即先对右子树进行入栈
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ans;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                // 如果不想对输出结果进行手动翻转
                // 也可以使用LinkedList.addFirst()
                // 每次都是添加头部节点，使得链表自动翻转
                ans.add(root.val);
                // Reverse the process of preorder
                root = root.right;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                // Reverse the process of preorder
                root = root.left;
            }
        }
        // 对输出结果进行翻转
        List<Integer> ret = new ArrayList<>();
        for (int i = ans.size() - 1; i >= 0; i--) {
            ret.add(ans.get(i));
        }
        return ret;
    }
}
