public class No61 {


    // 在进行旋转时，存在一种循环：如果循环次数等于链表长度时，链表就恢复为初始状态
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        k = k % length;

        ListNode pre = head;
        ListNode tail = pre.next;

        while (k > 0) {
            while (tail.next != null) {
                tail = tail.next;
                pre = pre.next;
            }
            tail.next = head;
            pre.next = null;

            head = tail;
            pre = tail;
            tail = tail.next;

            k--;
        }
        return head;
    }

    // 还有一种非暴力法，先计算出需要旋转的次数 l（取余之后）
    // 将节点移动到倒数第 l 位置处，旋转
    public static ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int length = 0;

        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        k = k % length;

        // 找到倒数第 k + 1 个节点
        // pre用于记录旋转后的新节点的前一个节点位置
        ListNode pre = head;
        ListNode tail = head;

        // 前一个节点先移动 k 步，用于找到倒数第 k +1 个节点的位置
        while (k > 0) {
            tail = tail.next;
            k--;
        }
        while (tail.next != null) {
            tail = tail.next;
            pre = pre.next;
        }

        tail.next = head;
        head = pre.next;
        pre.next = null;
        return head;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = null;
        rotateRight(listNode, 2);
    }


}
