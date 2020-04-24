package leetcode_with_name;

import java.util.ArrayList;
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
    // not ac
    public static int lengthOfLongestSubstring1(String s) {
        int[] f = new int[s.length()];
        f[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            // 初始值
            f[i] = f[i-1] + 1;
            // 找出前面与当前位置相同的index
            for (int j = i - 1; j >= f[i - 1]; j--) {
                if (s.charAt(j) == s.charAt(i)) {
                    f[i] = i - j;
                    break;
                }
            }
        }

        int max = 0;
        for (int len : f) {
            max = Math.max(max, len);
        }
        return max;

    }

}
