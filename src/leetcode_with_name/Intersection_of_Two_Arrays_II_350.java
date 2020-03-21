package leetcode_with_name;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection_of_Two_Arrays_II_350 {
    // 使用hash进行承载，因为数据不是有序的
    // 当然可以先对数组进行排序，但是会有一定的时间复杂度
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums1) {
            Integer value = map1.get(num);
            if (value == null) {
                map1.put(num, 1);
            } else {
                map1.put(num, value + 1);
            }
        }

        for (int num : nums2) {
            Integer value = map2.get(num);
            if (value == null) {
                map2.put(num, 1);
            } else {
                map2.put(num, value + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            Integer count1 = entry.getValue();
            Integer count2 = map2.get(entry.getKey());
            if (count1 == null) count1 = 0;
            if (count2 == null) count2 = 0;
            int count = Math.min(count1, count2);
            for (int i = 0; i < count; i++) {
                result.add(entry.getKey());
            }
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
