package leetcode_with_name;

public class Remove_Element_27 {
    // 要求原地移动，但是不要求最终的顺序
    // 可以使用首尾指针进行双向遍历
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int head = 0;
        int tail = nums.length - 1;
        while (head <= tail) {
            // head 右移直到等于val
            if (nums[head] != val) {
                head++;
            }
            // tail 左移直到不等于val
            if (nums[tail] == val) {
                tail--;
            }
            // 交换
            {
                int temp = nums[head];
                nums[head] = nums[tail];
                nums[tail] = temp;
            }
        }
        return head;
    }
}
