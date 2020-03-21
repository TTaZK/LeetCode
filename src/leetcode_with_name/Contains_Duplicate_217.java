package leetcode_with_name;

import java.util.HashMap;
import java.util.Map;

public class Contains_Duplicate_217 {
    // 有两种思路：1. 空间换时间；2. 时间换空间
    // O(n^2)，时间换空间，超时
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    // O(n)，空间换时间；看了讨论，基本都是采用这种方法，对于时间与空间都比较均衡
    public boolean containsDuplicate_2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                return true;
            }
        }
        return false;
    }
}
