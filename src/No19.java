public class No19 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 快慢指针
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        // last为first移动n步之后的节点（如果last节点移动的步数与链表的长度相同，那么last为null）
        // first的下一个节点就是将要移除的节点
        ListNode first, last;
        first = last = head;
        for (int i = 0; i < n; i++) {
            if (last != null) {
                last = last.next;
            }
        }
        // 说明此时没有进行移动（链表只有一个节点，且只能移除最后一个节点）
        if (last == first) {
            return null;
        }
        // 说明此时需要移除的节点为头节点(如果last节点移动的步数与链表的长度相同，那么last为null)
        // 此时需要移除倒数第n个节点，即头节点
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

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next = second;
        removeNthFromEnd(first, 2);
    }
}
