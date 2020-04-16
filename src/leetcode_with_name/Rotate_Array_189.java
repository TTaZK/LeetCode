package leetcode_with_name;

public class Rotate_Array_189 {
    public static void main(String[] args) {
        rotate(new int[]{1, 2}, 3);
    }

    // 反转数组
    // 将数组后面的k位反转到数组前面
    public static void rotate(int[] nums, int k) {
        // 分三次旋转操作，如 1,2,3,4,5
        // (1) -> 5,4,3,2,1
        // (2) -> 4,5,3,2,1
        // (3) -> 4,5,1,2,3
        k = k % nums.length;
        rotateWithIndex(nums, 0, nums.length - 1);
        rotateWithIndex(nums, 0, k - 1);
        rotateWithIndex(nums, k, nums.length - 1);
    }

    // 反转指定位置的子数组
    public static void rotateWithIndex(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
