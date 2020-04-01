package leetcode_with_name;

public class Odd_Even_Linked_List_328 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd, even, preEven;
        odd = head;
        preEven = even = head.next;
        while (odd != null || even != null) {
            if (odd != null && odd.next != null) {
                odd.next = odd.next.next;
                if (odd.next != null) {
                    odd = odd.next;
                }
            }

            if (even != null && even.next != null) {
                even.next = even.next.next;
                even = even.next;
            }
        }

        odd.next = preEven;
        return head;

    }
}
