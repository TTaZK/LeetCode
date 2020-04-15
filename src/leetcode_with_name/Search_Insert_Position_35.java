package leetcode_with_name;

public class Search_Insert_Position_35 {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                low = mid;
                break;
            }
        }
        // low 用于记录二分查找的终止位置
        if (nums[low] < target) {
            return low + 1;
        } else {
            return low;
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 6, 7, 8, 9};
        int target = 6;
        searchInsert(array, target);
    }
}
