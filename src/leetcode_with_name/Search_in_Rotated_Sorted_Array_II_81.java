package leetcode_with_name;

public class Search_in_Rotated_Sorted_Array_II_81 {

    // 先确定 target 所在的范围：是左半边上升还是右半边上升
    public static boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[low]) {
                // 此时 low ... mid 之间是有序的
                if (target >= nums[low] && target <= nums[mid]) {
                    // target 在左边
                    high = mid - 1;
                } else {
                    // target 在右边
                    low = mid + 1;
                }
            } else if (nums[mid] < nums[low]) {
                // 此时 mid ... high之间是有序的
                if (target >= nums[mid] && target <= nums[high]) {
                    // target 在右边
                    low = mid + 1;
                } else {
                    // target 在左边
                    high = mid - 1;
                }
            } else {
                low++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1};
        int target = 1;
        search(array, target);
    }
}
