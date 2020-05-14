package leetcode_with_name;

public class Sort_Colors_75 {
    // before
    // 先把0移动到前面，再把2移动到后面
    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        int first = 0;
        int second = 0;
        while (first <= second && second < n) {
            if (nums[second] == 0) {
                swap(nums, first, second);
                first++;
                second++;
            } else {
                second++;
            }
        }

        first = n - 1;
        second = n - 1;
        while (first <= second && first >= 0) {
            if (nums[first] == 2) {
                swap(nums, first, second);
                first--;
                second--;
            } else {
                first--;
            }
        }
    }

    public void swap(int[] nums, int begin, int end) {
        int temp = nums[begin];
        nums[begin] = nums[end];
        nums[end] = temp;
    }
}
