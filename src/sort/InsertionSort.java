package sort;

public class InsertionSort {

    public void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // 将nums[i]插入到nums[i-1],nums[i-2]...nums[0]中
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j - 1, j);
                }
            }
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
        new InsertionSort().insertionSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
