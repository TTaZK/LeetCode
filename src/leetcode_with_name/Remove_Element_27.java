package leetcode_with_name;

public class Remove_Element_27 {
    // 要求原地移动，但是不要求最终的顺序
    // 可以使用首尾指针进行双向遍历
    // 总是存在边界问题
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int head = -1;
        int tail = nums.length;
        while (true) {
            // head 右移直到等于val
            while (nums[++head] != val) {
                if (head >= tail) break;
            }
            // tail 左移直到不等于val
            while (nums[--tail] == val) {
                if (tail <= head) break;
            }
            if (head >= tail) break;
            // 交换
            {
                int temp = nums[head];
                nums[head] = nums[tail];
                nums[tail] = temp;
            }
        }
        // 交换回来
        {
            int temp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = temp;
        }
        return head;
    }

    // 因为只是返回数组的前部分元素，对于数组后部分元素不做要求
    // 所以可以只考虑将符合要求的元素填充到前半部分
    // 只用到单向指针，效率较高
    // ac
    public static int removeElement1(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        // 用于记录填充元素的位置
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                // 此时将j位置的元素填充到i位置上
                nums[i] = nums[j];
                // 移动到下一位
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 2, 3};
        removeElement(array, 3);
    }
}
