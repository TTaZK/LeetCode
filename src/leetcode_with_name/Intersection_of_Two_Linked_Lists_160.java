package leetcode_with_name;

import java.util.Stack;

public class Intersection_of_Two_Linked_Lists_160 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 利用栈FILO的特点，从后向前遍历
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        // push link A into stack
        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        // push link B into stack
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }
        // pop and compare
        ListNode ans = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode topA = stackA.pop();
            ListNode topB = stackB.pop();
            if (topB != topA) {
                return ans;
            }
            ans = topA;
        }
        return ans;
    }
}
