public class No300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 0) {
            return 0;
        }
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                f[i] = f[i - 1] + 1;
            } else {
                f[i] = 1;
            }
        }
        int max = 1;
        for (int temp : f) {
            max = max > temp ? max : temp;
        }
        return max;
    }
}
