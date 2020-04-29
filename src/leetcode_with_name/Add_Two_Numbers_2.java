package leetcode_with_name;

public class Add_Two_Numbers_2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tag = 0;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (true) {
            int v1 = 0, v2 = 0;
            if (l1 == null && l2 != null) {
                v1 = 0;
                v2 = l2.val;
                l2 = l2.next;
            } else if (l2 == null && l1 != null) {
                v2 = 0;
                v1 = l1.val;
                l1 = l1.next;
            } else if (l1 != null && l2 != null) {
                v1 = l1.val;
                v2 = l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null && l2 == null && tag == 0) {
                break;
            }
            head.next = new ListNode((v1 + v2 + tag) % 10);
            tag = (v1 + v2 + tag) / 10;
            head = head.next;
        }
        return temp.next;
    }
}
