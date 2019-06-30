public class No142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        // 记录相遇节点
        ListNode meet = null;

        // 快指针走的快，所以如果快指针不为空，意味着慢指针也不会为空
        // 不断循环，如果两个指针存在相等的情况，则此时相遇
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                meet = slow;
                break;
            }
        }
        // 此时不存在环
        if (fast.next == null || fast.next.next == null) {
            return null;
        }
        while (meet != head) {
            meet = meet.next;
            head = head.next;
        }
        return meet;
    }
}
