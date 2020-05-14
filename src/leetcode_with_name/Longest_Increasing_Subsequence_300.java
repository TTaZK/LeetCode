package leetcode_with_name;

public class Longest_Increasing_Subsequence_300 {
    // 设长度为N的数组为{a0，a1, a2, ...an-1)，则假定以aj结尾的数组序列的最长递增子序列长度为L(j)，则L(j)={ max(L(i))+1, i<j且a[i]<a[j] }。
    // 也就是说，我们需要遍历在j之前的所有位置i(从0到j-1)，找出满足条件a[i]<a[j]的L(i)，求出max(L(i))+1即为L(j)的值。
    // 最后，我们遍历所有的L(j)（从0到N-1），找出最大值即为最大递增子序列。
    // f[i] = max{f[j] + 1},0<=j<i
    // 类似于钢条切割，现求出子集的最优解，再找出全集的最优解
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] f = new int[nums.length];

        for (int i = 0; i < f.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        int max = 0;
        for (int v : f) {
            max = Math.max(v, max);
        }
        return max;
    }

    // 之前的做法
    // tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
    // tail 的最后一个元素为，长度为tail.length的递增子序列的最小值
    //For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:
    //
    //len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
    //len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
    //len = 3   :      [4, 5, 6]            => tails[2] = 6
    //We can easily prove that tails is a increasing array. Therefore it is possible to do a binary search in tails array to find the one needs update.
    //
    //Each time we only do one of the two:
    //
    //(1) if x is larger than all tails, append it, increase the size by 1
    //(2) if tails[i-1] < x <= tails[i], update tails[i]
    //Doing so will maintain the tails invariant. The the final answer is just the size.
    public int lengthOfLIS1(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    // 只有X大于当前值，数组的长度才能增加
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 9, 4, 10, 5, 6};
        lengthOfLIS(a);
    }

}
