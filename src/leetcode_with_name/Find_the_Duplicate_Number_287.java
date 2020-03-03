package leetcode_with_name;

public class Find_the_Duplicate_Number_287 {
    // Loop traversal is performed using two pointers respectively,
    // the outer traversal is used to identify the current element,
    // and the inner traversal is used to find
    // whether the current element has the same value after the current element.
    // time comp O(n*n)
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] == nums[i]) {
                    return nums[j];
                }
            }
        }
        return 0;
    }

    /*
    NOTE:
    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n2).
    There is only one duplicate number in the array, but it could be repeated more than once
     */
}
