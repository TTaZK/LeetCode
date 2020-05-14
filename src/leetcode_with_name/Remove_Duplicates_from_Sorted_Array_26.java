package leetcode_with_name;

public class Remove_Duplicates_from_Sorted_Array_26 {
    // before
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int count = 1;
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
                count++;
            }
            j++;

        }
        return count;
    }
}
