package sort;

public class MergeSort {
    // 要对子数组 nums[low...high]进行排序，先将它分为 nums[low...mid] 与 nums[mid+1...high]两部分
    // 分别通过递归调用它们单独排序，最后将有序的子数组归并为最终的结果
    // 归并排序需要借助一个额外的数组进行归并，空间复杂度为O(n)

    public int[] aux;

    public void mergeSort(int[] nums) {
        aux = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
    }

    public void mergeSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    public void merge(int[] nums, int low, int mid, int high) {
        int i = low, j = mid + 1;
        // 复制元素到临时数组中
        for (int k = low; k <= high; k++) {
            aux[k] = nums[k];
        }

        // 合并子数组
        for (int k = low; k <= high; k++) {
            // 左子数组为空
            if (i > mid) {
                nums[k] = aux[j++];
            }
            // 右子数组为空
            else if (j > high) {
                nums[k] = aux[i++];
            } else if (aux[i] >= aux[j]) {
                nums[k] = aux[j++];
            } else {
                nums[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {7, 3, 4, 2, 8, 23, 14, 1, 34, 4};
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        new MergeSort().mergeSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
