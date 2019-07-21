package leetcode_with_name;

import java.util.ArrayList;
import java.util.List;

public class InversePairs {
    // 求数组的逆序对的数量（整体思路采用类似归并排序的过程）
    // 采用归并算法：先对整个数组进行拆分（均等拆分），然后再对数组进行合并，在合并的过程中统计逆序对的数目
    // 注意：合并后的结果是有序的子数组
    public int reversePairs1(int[] nums) {
        return 0;
    }

    public int reversePairs1(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        reversePairs1(nums, low, mid);
        reversePairs1(nums, mid + 1, high);
        return mergePairs1(nums, low, mid, high);
    }

    public int mergePairs1(int[] nums, int low, int mid, int high) {
        int i = low, j = mid + 1;
        for (int k = i; k <= high; k++) {

        }
        return 0;
    }

    // 其实这题可不可以使用回溯法
    // 按序求解当前数组的子集，统计那些长度为2的子集中的逆序对的个数
    public static int reversePairs(int[] nums) {
        List<Integer> count = new ArrayList<>();
        count.add(0);
        reversePairs(nums, 0, count, new ArrayList<>());
        return count.get(0);
    }

    public static void reversePairs(int[] nums, int level, List<Integer> count, List<Integer> cur) {
        if (level >= nums.length) {
            if (cur.size() == 2 && cur.get(0) > cur.get(1)) {
                count.set(0, count.get(0) + 1);
                for (int v : cur) {
                    System.out.print(v + " ");
                }
                System.out.println();
                return;
            }
            return;
        }
        reversePairs(nums, level + 1, count, new ArrayList<>(cur));
        cur.add(nums[level]);
        reversePairs(nums, level + 1, count, new ArrayList<>(cur));
    }

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{7, 5, 6, 4}));
    }

}
