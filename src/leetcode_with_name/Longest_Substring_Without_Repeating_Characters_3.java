package leetcode_with_name;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Longest_Substring_Without_Repeating_Characters_3 {
    // 该题目主要使用回溯，想要确定第i位置的长度，那么需要将第i个字符与前f[i-1]个字符进行比较
    // 如果与倒数第一个字符相等，则f[i]=1；如果与倒数第x字符相等，则f[i] = (x -1) + 1 = x
    // update: 好像与回溯没关系。。。
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 0) {
            return 0;
        }
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] + 1;
            char c = s.charAt(i);
            for (int j = 0; j < f[i - 1]; j++) {
                if (s.charAt(i - j - 1) == c) {
                    f[i] = j + 1;
                    break;
                }
            }
        }
        int max = 1;
        for (int i = 0; i < n; i++) {
            max = max < f[i] ? f[i] : max;
        }
        return max;
    }

    // rewrite
    // 使用hashmap 存储已经出现的字符
    // ac
    public static int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) return 0;
        int max = 1;
        // key: 已经出现的字符；value: 该字符出现的位置
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while (left <= right && right < s.length()) {
            Integer position = map.get(s.charAt(right));
            // 更新当前字符最近出现的位置
            map.put(s.charAt(right), right);
            if (position != null) {
                // 更新左指针的位置：出现相同元素的最大位置，可能是之前的相同元素，也可能是本次相同的元素
                left = Math.max(left, position + 1);
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abba"));
    }

}
