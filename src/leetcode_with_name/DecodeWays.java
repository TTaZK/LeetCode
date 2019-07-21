package leetcode_with_name;

public class DecodeWays {
    // 采用DP，f[i]表示前i个长度的序列的编码方式，那么当s[i-1]>2 || s[i-1]*10 + s[i] > 26，那么此时f[i] = f[i-1]
    // 不然说明s[i-1]s[i]这两个序列能够有两种编码方式，则f[i] = f[i-2]+2
    public static int numDecodings(String s) {
        int n = s.length();
        if (n < 1) return 0;
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = s.charAt(0) == 48 ? 0 : 1;
        for (int i = 2; i < n + 1; i++) {
            int v = s.charAt(i - 2) - 48;
            int v2 = s.charAt(i - 1) - 48;
            if (v == 0 && v2 == 0) {
                return 0;
            }
            if (v > 2 || v * 10 + v2 > 26 || v * 10 + v2 == 10) {
                f[i] = f[i - 1];
            } else {
                f[i] = f[i - 2] + 2;
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        numDecodings("10");
    }
}
