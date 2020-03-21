package leetcode_with_name;

public class Decode_Ways_91 {
    // f[i] 表示能够解码的种类数目； f[i] = f[i-1](此时s[i]与s[i-1]不能合并)/ f[i-2]*2 + f[i-1](此时s[i]与s[i-1]能合并)
    public int numDecodings(String s) {
        if (s.length() == 0 || s.length() == 1 && convertCharToInt(s, 0) == 0) return 0;
        int[] f = new int[s.length() + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < s.length() + 1; i++) {
            int value = convertCharToInt(s, i - 2) * 10 + convertCharToInt(s, i - 1);
            if (value <= 26 && value > convertCharToInt(s, i - 1)) {
                f[i] = f[i - 1] + f[i - 2];
            } else {
                f[i] = f[i - 1];
            }
        }
        return f[s.length()];
    }

    public int convertCharToInt(String s, int index) {
        return s.charAt(index) - 'A';
    }

    public static void main(String[] args) {

    }
}
