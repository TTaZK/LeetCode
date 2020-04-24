package leetcode_with_name;

public class Longest_Uncommon_Subsequence_I_521 {
    // 最长公共子序列的相反情况：求最长非公共子序列
    // 采取类似LCS的做法
    // f[i][j] = f[i-1][j-1] + 1   if a[i] != b[j]
    //         = max{f[i-1][j], f[i][j-1]}    if a[i] == b[j]
    // 理解错题目意思了。。。
    public static int findLUSlength(String a, String b) {
        if (a.length() == 0) return b.length();
        if (b.length() == 0) return a.length();
        int[][] f = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) != b.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[a.length()][b.length()] > 0 ? f[a.length()][b.length()] : -1;
    }

    // ac
    public int findLUSlength1(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        String a = "aba";
        String b = "cdc";
        findLUSlength(a, b);
    }
}
