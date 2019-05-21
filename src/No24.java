public class No24 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 该方法只会交换一对一对的节点，但是成对节点之间的关联出错
    // 即mid与last之间的关系
    public static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ret = head.next;
        ListNode first = head;
        ListNode mid = head.next;
        while (mid != null) {
            ListNode last = mid.next;
            first.next = last;
            mid.next = first;
            if (last != null) {
                first = last;
                mid = first.next;
            } else {
                break;
            }
        }
        return ret;
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = head.next;
        ListNode temp = node.next;
        node.next = head;
        head.next = swapPairs(temp);
        return node;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        ListNode head = swapPairs1(node1);
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
    }
}
