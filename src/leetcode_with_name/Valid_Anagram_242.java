package leetcode_with_name;

import java.util.Arrays;

public class Valid_Anagram_242 {
    // 当前思路是对两个字符串进行排序，如果一致的话说明是同字母异序的单词
    public static boolean isAnagram(String s, String t) {
        if (s.length() == 0 && t.length() == 0) return true;
        if (s.length() == 0 || t.length() == 0) return false;
        char[] tArray = t.toCharArray();
        char[] sArray = s.toCharArray();
        Arrays.sort(tArray);
        Arrays.sort(sArray);
        return Arrays.toString(tArray).equals(Arrays.toString(sArray));
    }

    // 但是题目中有个比较特殊的条件，两个字符串都是由小写字母组成
    // 那么可以统计每个字符串中各个小写字母出现的次数，如果出现的字母次数都相同，则是同字母异序的单词
    public static boolean isAnagram1(String s, String t) {
        // 用于记录每个字母出现的个数
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            counts[c - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) {
                // 说明个数不一致
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        isAnagram(s, t);
    }
}
