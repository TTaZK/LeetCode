package leetcode_with_name;

import java.util.List;
import java.util.Objects;

public class Palindromic_Substrings_647 {
    // 比较简单的方法是先求出该字符串的所有子串
    // 然后再找出回文子串
    public int countSubstrings(String s) {
        backTrack(s, 0, "");
        return count;
    }

    int count = 0;

    public void backTrack(String s, int level, String cur) {
        if (level >= s.length() && isPalindromic(cur)) {
            count++;
        } else {
            // not input
            backTrack(s, level + 1, new String(cur));
            // input
            backTrack(s, level + 1, cur + s.charAt(level));
        }
    }

    public boolean isPalindromic(String s) {
        String str = new StringBuffer(s).reverse().toString();
        if (Objects.equals(s, str)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
