package leetcode_with_name;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Duplicates_in_an_Array_442 {
    // 在题目中指明，1 ≤ a[i] ≤ n (n = size of array)
    // 即数组中元素的值不会大于整个数组的长度
    // 所以存在比较特殊的解法：找到数字i时，将位置i-1处的数字翻转为负数。
    // 如果位置i-1上的数字已经为负，则i是出现两次的数字。
    // 当然，如果不存在空间复杂度的限制，则可以使用map
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                res.add(Math.abs(index + 1));
            nums[index] = -nums[index];
        }
        return res;
    }
}
