package leetcode_with_name;

import java.util.PriorityQueue;

public class Merge_k_Sorted_Lists_23 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k <= 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(k, (a, b) ->
                a.val - b.val
        );
        ListNode head = new ListNode(0);
        ListNode first = head;
        for (int i = 0; i < k; i++) {
            if (lists[i] == null) {
                continue;
            }
            priorityQueue.add(lists[i]);
        }

        while (!priorityQueue.isEmpty()) {
            ListNode temp = priorityQueue.poll();
            if (temp.next != null) {
                priorityQueue.add(temp.next);
            }
            first.next = temp;
            first = first.next;
        }
        return head.next;
    }
}
