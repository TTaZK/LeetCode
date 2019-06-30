public class No92 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;
        int index = 0;
        ListNode pre, cur;
        ListNode sub_tail = null, sub_head = null;
        ListNode temp = head;
        // 找到第 m -1 与 n + 1 位置的节点
        // 分别为翻转子链的尾部与首部
        while (index < n + 1 && temp != null) {
            index++;
            if (index == m - 1) {
                sub_head = temp;
            } else if (index == n) {
                sub_tail = temp;
            }
            temp = temp.next;
        }

        pre = sub_tail;
        cur = sub_head.next;
        while (cur != sub_tail) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        sub_head.next = pre;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        reverseBetween(listNode, 2, 4);
    }
}
