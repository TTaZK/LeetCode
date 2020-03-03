package problems;

public class No392 {
    // 首先想到的方法是，求s,t的最长公共子序列长度
    // 如果长度为s的长度，则s是t的子序列，否则不满足
    // 或者换一种思路，对s,t进行遍历，如果s中的字符在t中都能顺序地找到
    // 则满足要求
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        if (s.length() == 0 || (s.length() == 0 && t.length() == 0)) return true;
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            char c = s.charAt(i++);
            while (t.charAt(j++) != c) {
                if (j >= t.length()) {
                    return false;
                }
            }
            if (i == s.length() && j <= t.length()) {
                return true;
            }
        }
        return false;
    }
}
