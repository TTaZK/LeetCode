package leetcode_with_name;

public class Longest_Palindromic_Subsequence_516 {
    // 最长回文子序列；注意子序列与子串的区别
    // 回顾 no.647，也可以使用回溯法
    // 不过最常用的是DP：先反转字符串，然后求出两个字符串的最长公共子序列
    // 先考虑用回溯--->使用回溯又出现与no.647的同样的问题，本地调试结果与leetcode结果不一致
    public static int longestPalindromeSubseq(String s) {
        backTrack(s, 0, "");
        return count;
    }

    static int count = 0;

    public static void backTrack(String s, int level, String cur) {
        if (level >= s.length()) {
            // 不能写成 level >= s.length() && isPalindromic(cur) 不然代码不会进入到该语句块中
            if (isPalindromic(cur)) {
                // System.out.println(cur);
                count = Math.max(count, cur.length());
            }
        } else {
            // not add
            backTrack(s, level + 1, cur);
            // add
            String sub = cur + s.charAt(level);
            backTrack(s, level + 1, sub);
        }
    }

    public static boolean isPalindromic(String s) {
        if (s.length() == 0) return false;
        int head = 0;
        int tail = s.length() - 1;
        while (head <= tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }

    // 还是老老实实用DP吧
    public static int longestPalindromeSubseq1(String s) {
        StringBuffer sb = new StringBuffer(s);
        String s2 = sb.reverse().toString();
        return LCS(s, s2);
    }

    // f[i,j] = f[i-1,j-1]+1 if s1[i] == s2[j]
    //        = max{ f[i-1,j], f[i,j-1] } if s1[i] != s2[j]
    public static int LCS(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) return 0;
        int[][] f = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) f[i][j] = f[i - 1][j - 1] + 1;
                else f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
            }
        }
        return f[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("cbbd"));
    }
}
