package leetcode_with_name;

public class Remove_Nth_Node_From_End_of_List_19 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // before
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode head_next = head.next;
        ListNode first, last;
        first = last = head;
        for (int i = 0; i < n; i++) {
            if (last != null) {
                last = last.next;
            }
        }
        if (last == first) {
            return null;
        }
        if (last == null) {
            return head.next;
        }
        // 将last节点移动到链表末尾
        while (last.next != null) {
            last = last.next;
            first = first.next;
        }

        // 将要移除的节点
        ListNode will_remove = first.next;
        ListNode next = will_remove.next;

        first.next = next;
        will_remove = null;

        return head;
    }
}
