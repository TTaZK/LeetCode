package leetcode_with_name;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array_34 {
    // before
    // 先用二分查找找到目标元素在数组中的其中一个位置
    // 然后从该位置向两个方向扩散
    public int[] searchRange(int[] nums, int target) {
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
                first = last = mid;
                while (--first >= 0) {
                    if (nums[first] != target) {
                        break;
                    }
                }
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
}
