package leetcode_with_name;

// 最长回文子串（不是子序列）
public class Longest_Palindromic_Substring_5 {
    // 之前的代码
    //
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    // rewrite
    // 对于每个元素向两个方向进行遍历
    // ac
    int l = 0;
    int r = 0;

    public String longestPalindrome1(String s) {
        if (s.length() == 0) return "";
        for (int i = 0; i < s.length(); i++) {
            // 考虑字符串长度为奇数
            travel(s, i, i);
            // 考虑字符串长度为偶数
            travel(s, i, i + 1);
        }
        return s.substring(l + 1, r);
    }

    // 从left, right 分别向两个方向进行遍历
    public void travel(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // update
        // 注意此时left， right 的取值需要修正：此时 s.charAt(left) != s.charAt(right)
        if (right - left > r - l) {
            l = left;
            r = right;
        }
    }
}
