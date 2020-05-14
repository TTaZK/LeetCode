package leetcode_with_name;

import java.util.ArrayList;
import java.util.List;

public class Summary_Ranges_228 {
    // 字符串有序并且无重复
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length <= 0) return res;
        int start, end;
        start = end = 0;
        while (end <= nums.length) {
            if (end < nums.length && (end == start || nums[end] == nums[end - 1] + 1)) {
                end++;
            } else {
                if (end == start + 1) {
                    res.add(nums[start] + "");
                } else {
                    res.add(nums[start] + "->" + nums[end - 1]);
                }
                if (end >= nums.length) break;
                start = end;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2, 4, 5, 7};
        summaryRanges(a);
    }
}
