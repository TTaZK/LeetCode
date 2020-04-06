package leetcode_with_name;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Plus_One_66 {
    // 最简单的方式是先求出数组代表的数值，然后加1 --- 有问题，会存在溢出的现象
    // 或者说从当前数组的尾部开始加1，当然需要解决进位的问题
    public int[] plusOne(int[] digits) {
        // not ac
        List<Integer> list = new ArrayList<>();
        int number = 0;
        int value = 0;
        for (int i : digits) {
            number = number * 10 + i;
        }
        value = number + 1;
        while (value > 0) {
            int v = value % 10;
            value = value / 10;
            list.add(v);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[list.size() - 1 - i] = list.get(i);
        }
        return res;
    }

    public int[] plusOne1(int[] digits) {
        int flag = (digits[digits.length - 1] + 1) / 10;
        digits[digits.length - 1] = (digits[digits.length - 1] + 1) % 10;
        if (digits.length >= 2) {
            for (int i = digits.length - 2; i >= 0; i--) {
                int value = digits[i] + flag;
                digits[i] = value % 10;
                flag = value / 10;
            }
        }
        if (flag > 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            return res;
        } else {
            return digits;
        }
    }
}
