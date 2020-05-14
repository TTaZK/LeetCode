package leetcode_with_name;

import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum_1 {
    // before
    // ac
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length < 2) {
            return result;
        }

        // 使用HashMap进行存储，其中key为对应的值，value为索引
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(target - nums[i]) != null) {
                result[0] = hashMap.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            hashMap.put(nums[i], i);
        }
        return result;
    }

    // rewrite: use two pointer
    // wrong
    // 不能采用排序，会修改之前的index
    public int[] twoSum1(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] ans = new int[2];
        Arrays.sort(nums);
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum > target) end--;
            else if (sum == target) {
                ans[0] = start;
                ans[1] = end;
                return ans;
            } else {
                start++;
            }
        }
        return ans;
    }


}
