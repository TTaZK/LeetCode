package leetcode_with_name;

public class Palindrome_Linked_List_234 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //  O(n) time and O(1) space
    // 如果不考虑空间复杂度的话，可以先构造出与当前链表结构相同的链表 B
    // 然后将 B 反转，并与原链表进行比较
    // 参照讨论，可以反转一半链表，然后将两部分进行比较
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        // 1. find middle point
        ListNode slow, fast, middle;

        slow = fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        middle = slow;
        // 2. reverse half link
        ListNode next = head.next;
        head.next = null;
        while (next != null && next != middle) {
            ListNode temp = next.next;
            next.next = head;

            head = next;
            next = temp;
        }
        // 3. compare
        // 如果链表长度为奇数，则middle在中位数
        // 如果链表长度为偶数，则middle在中位数的下一位
        // 所以进行两种情况的判断，只要满足其中一个即可
        return compare(head, slow) || compare(head, slow.next);
    }

    public static boolean compare(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 == null && head2 == null) return true;
        if (head1 == null || head2 == null) return false;
        return true;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(0);
        a.next = b;
        isPalindrome(a);
    }
}

