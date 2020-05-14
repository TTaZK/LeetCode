package leetcode_with_name;

public class Median_of_Two_Sorted_Arrays_4 {
    // before
    // ac
    // 采用类似归并排序，两个有序数组合并
    // 有种时间复杂度更小的方式，采用二分查找：https://mp.weixin.qq.com/s/FBlH7o-ssj_iMEPLcvsY2w
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l_1 = nums1.length;
        int l_2 = nums2.length;
        int l = l_1 + l_2;
        int[] merge = new int[l];

        int index, index_1, index_2;
        index = index_1 = index_2 = 0;

        while (index < l) {
            int value_1, value_2;
            value_1 = value_2 = Integer.MAX_VALUE;
            if (index_1 < l_1) {
                value_1 = nums1[index_1];
            }
            if (index_2 < l_2) {
                value_2 = nums2[index_2];
            }
            // input into merged array
            int value = Math.min(value_1, value_2);
            merge[index++] = value;

            if (value == value_1) {
                index_1++;
            } else {
                index_2++;
            }
        }

        if (l % 2 == 0) {
            return ((double) merge[l / 2] + (double) merge[l / 2 - 1]) / 2;
        } else {
            return merge[l / 2];
        }
    }

    // rewrite
    // 因为只需要找到中位数，是不是可以找到中间元素的值即可，不需要将全部的元素都进行排序
    // 只需要记录中位数元素的index即可
    // 不尝试了
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        double ans = 0;
        if (nums1.length <= 1 && nums2.length <= 1) {
            ans = (nums1[0] + nums2[0]) / 2;
            return ans;
        }
        int curIndex = 2;
        int targetMinIndex = 0;
        int targetMaxIndex = 0;
        if ((nums1.length + nums2.length) % 2 == 0) {
            targetMinIndex = (nums1.length + nums2.length) / 2 - 1;
            targetMaxIndex = (nums1.length + nums2.length) / 2;
        } else {
            targetMinIndex = (nums1.length + nums2.length) / 2;
            targetMaxIndex = (nums1.length + nums2.length) / 2;
        }
        return 0;
    }

    // 二分查找
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //一个小技巧：将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
