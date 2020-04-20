package leetcode_with_name;

public class Majority_Element_169 {
    public static int majorityElement(int[] nums) {
        int vote = 0, ans = 0;
        for (int cur : nums) {
            if (vote == 0) {
                ans = cur;
            }
            if (ans == cur) {
                vote++;
            } else {
                vote--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2, 4, 2, 2};
        majorityElement(nums);
    }
}
