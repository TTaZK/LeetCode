package leetcode_with_name;

import java.util.Arrays;

public class Longest_Common_Prefix_14 {
    // 最长公共前缀
    // 先把所有字符串排序，然后比较第一个字符串与最后一个字符串的最长公共前缀的长度
    // 即为所有字符串最长公共前缀
    // rewrite
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        Arrays.sort(strs);
        String start = strs[0];
        String end = strs[strs.length - 1];
        int index = 0;
        while (index < start.length() && index < end.length()) {
            if (start.charAt(index) != end.charAt(index)) {
                break;
            }
            index++;
        }
        return start.substring(0, index); // [ )
    }

    // 之前的提交
    // ac
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length <= 0) return "";
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        String ans = "";
        int index = 0;
        while (first.length() > index && last.length() > index) {
            if (first.charAt(index) == last.charAt(index)) {
                ans = ans + first.charAt(index);
            } else {
                break;
            }
            index++;
        }
        return ans;
    }
}
