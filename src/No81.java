public class No81 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                low = mid + 1;
            } else if (nums[mid] < target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
