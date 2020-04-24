package leetcode_with_name;

public class Number_of_Longest_Increasing_Subsequence_673 {
    // The idea is to use two arrays len[n] and cnt[n] to record the maximum length of Increasing Subsequence and
    // the coresponding number of these sequence which ends with nums[i], respectively. That is:
    //
    //len[i]: the length of the Longest Increasing Subsequence which ends with nums[i].
    //cnt[i]: the number of the Longest Increasing Subsequence which ends with nums[i].
    //
    //Then, the result is the sum of each cnt[i] while its corresponding len[i] is the maximum length.
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] len = new int[n], cnt = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1) cnt[i] += cnt[j];
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if (max_len == len[i]) res += cnt[i];
            if (max_len < len[i]) {
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }

    // rewrite
    // 未排序数组最长递增子序列长度（子序列不是子数组）
    // f[i]表示到i位置最长子序列的长度
    // 依次比较i与 i-1,i-2...0位置上元素的大小，f[i] = max{f[j]}+1 其中 0<=j<i, 并且f[j] < f[i]
    // 求出最长子序列的长度之后，需要再求出最长子序列的数目
    // LIS 没有问题，但是统计数目出现问题
    public static int findNumberOfLIS1(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] f = new int[nums.length];
        f[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        int max = 1;
        int num = 1;
        for (int len : f) {
            if (max < len) {
                num = 1;
            } else if (max == len) {
                num++;
            }
            max = Math.max(max, len);
        }
        return num;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 4, 7};
        findNumberOfLIS1(a);
    }
}
