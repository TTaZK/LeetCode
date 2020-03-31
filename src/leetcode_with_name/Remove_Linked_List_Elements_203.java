package leetcode_with_name;

public class Remove_Linked_List_Elements_203 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 单向遍历，遇到指定的元素就进行删除
    // not ac
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        // 前置节点
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode cur = preHead;
        while (cur != null) {
            if (cur.next != null && cur.next.val == val) {
                ListNode next = cur.next.next;
                cur.next = next;
            }
            cur = cur.next;
        }
        return preHead.next;
    }

    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) return null;
        // 增加前置节点
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode cur = preHead;
        while (cur != null) {
            // 如果下一个节点需要删除，则将其进行删除，但是不更新当前节点的位置
            // 在下一个节点不需要删除的情况下才更新当前节点的位置
            if (cur.next != null && cur.next.val == val) {
                ListNode next = cur.next.next;
                cur.next = next;
            } else {
                cur = cur.next;
            }
        }
        return preHead.next;
    }
}
