public class No34 {

    public static int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int start, end, first, last;
        first = last = -1;
        if (length <= 0) {
            return new int[]{first, last};
        }
        start = 0;
        end = length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                // 在进行左右边界寻找的时候，可以对两边都采用二分查找来实现
                first = last = mid;
                // 找出左边界
                while (--first >= 0) {
                    if (nums[first] != target) {
                        break;
                    }
                }
                // 找出右边界
                while (++last < length) {
                    if (nums[last] != target) {
                        break;
                    }
                }
                return new int[]{++first, --last};
            }
        }
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        searchRange(new int[]{2, 2}, 3);
    }

}
