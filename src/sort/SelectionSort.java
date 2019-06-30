package sort;

public class SelectionSort {
    // 每次都是从剩余元素中选择最小的一个
    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // min用于记录最小值的索引位置
            int min = i;
            for (int j = i; j < nums.length; j++) {
                min = nums[j] < nums[min] ? j : min;
            }
            swap(nums, min, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {7, 3, 4, 2, 8, 23, 14, 1};
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        new SelectionSort().selectionSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
