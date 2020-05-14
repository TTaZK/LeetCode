package leetcode_with_name;

import java.util.List;

public class Convert_Sorted_List_to_Binary_Search_Tree_109 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 链表有序
    // 将有序数组进行转换时，采用的是每次取数组的中间节点，然后递归
    // 从而保证高度平衡
    // 对于链表，其实也可以采用每次取中间节点，但是时间复杂度高一点
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return sortedListToBST(head, null);
    }

    public static TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if (head == tail) return null;

        ListNode mid = middleNode(head, tail);
        TreeNode root = new TreeNode(mid.val);

        TreeNode left = sortedListToBST(head, mid);
        TreeNode right = sortedListToBST(mid.next, tail);

        root.left = left;
        root.right = right;
        return root;
    }

    public static ListNode middleNode(ListNode head, ListNode tail) {
        ListNode slow, fast;
        slow = head;
        fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode mid = new ListNode(2);
        ListNode tail = new ListNode(3);
        head.next = mid;
        mid.next = tail;
        sortedListToBST(head);
    }
}
