package sort;

import java.util.PriorityQueue;

public class                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   QuickSort {

    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int j = partition(nums, low, high);
        quickSort(nums, low, j - 1);
        quickSort(nums, j + 1, high);
    }

    private int partition(int[] nums, int low, int high) {
        int i = low, j = high + 1;
        int value = nums[low];
        while (true) {
            // 这里先使用 ++i 目的是在其中一次交换完成之后
            // 下一次的遍历直接进入下一个节点
            while (nums[++i] <= value) {
                // 防止指针越界
                if (i >= high) {
                    break;
                }
            }

            while (nums[--j] > value) {
                // 防止指针越界
                if (j <= low) {
                    break;
                }
            }

            // 两指针相遇，循环结束
            if (i >= j) {
                break;
            }
            // 交换找到的节点
            swap(nums, i, j);
        }
        // 因为使用的是 --j ， ++i, 那么最后两个指针一定会交叉（不是正好指在同一个位置）
        swap(nums, low, j);
        return j;
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
        new QuickSort().quickSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
