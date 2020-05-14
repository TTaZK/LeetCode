package leetcode_with_name;

public class Merge_Two_Sorted_Lists_21 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // before
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head, temp;
        head = temp = new ListNode(0);
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                temp.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                temp.next = l1;
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        return head.next;
    }

    // rewrite
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                head.next = l2;
                break;
            }
            if (l2 == null) {
                head.next = l1;
                break;
            }

            ListNode next = l1.val < l2.val ? l1 : l2;
            head.next = next;
            head = head.next;

            // iterator
            if (next == l1) {
                l1 = l1.next;
            }
            if (next == l2) {
                l2 = l2.next;
            }
        }
        return temp.next;
    }

}
