package leetcode_with_name;

public class Product_of_Array_Except_Self_238 {
    // 看到题目首先想到先计算出整个数据元素的乘积，之后再除以对应位置的元素
    // 但是这种做法要注意其中存在0的情况，存在一个0/存在多个0
    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 0) return null;
        int[] ans = new int[nums.length];
        int zeroCount = 0;
        int zeroIndex = -1;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (zeroIndex != -1 && nums[i] == 0) {
                // 说明数组中存在不止一个0
                product = 0;
                break;
            }
            if (nums[i] == 0) {
                zeroIndex = i;
            } else {
                product *= nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (product == 0) {
                nums[i] = 0;
                continue;
            }
            if (zeroIndex != -1 && zeroIndex != i) {
                nums[i] = 0;
            } else if (zeroIndex != -1) {
                nums[i] = product;
            } else {
                nums[i] = product / nums[i];
            }
        }
        return nums;
    }

    // 题目中要求不使用除法
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        if (n <= 0) return null;
        // 用于存储当前索引左边元素的乘积
        int[] left = new int[n];
        // 用于存储当前索引右边元素的乘积
        int[] right = new int[n];
        // 用于存储最终结果
        int[] ans = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

//    Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except 4 is 2*3*5 which consists of two parts: left 2*3 and right 5. The product is left*right. We can get lefts and rights:
//
//Numbers:     2    3    4     5
//Lefts:            2  2*3 2*3*4
//Rights:  3*4*5  4*5    5
//Let’s fill the empty with 1:
//
//Numbers:     2    3    4     5
//Lefts:       1    2  2*3 2*3*4
//Rights:  3*4*5  4*5    5     1
//We can calculate lefts and rights in 2 loops. The time complexity is O(n).
}
