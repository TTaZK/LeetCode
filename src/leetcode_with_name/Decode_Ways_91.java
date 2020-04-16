package leetcode_with_name;

public class Decode_Ways_91 {
    // f[i] 表示能够解码的种类数目； f[i] = f[i-1](此时s[i]与s[i-1]不能合并)/ f[i-2] + f[i-1](此时s[i]与s[i-1]能合并)
    // 注意：即使尾部两个数字能够合并，也需要考虑合并之后的值是否在 1-26范围之内
    // ac
    public static int numDecodings(String s) {
        // 长度为0 or start with 0
        if (s.length() == 0 || convertCharToInt(s, 0) == 0) return 0;
        if (s.length() == 1) return 1;
        // init
        int[] f = new int[s.length() + 1];
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i < s.length() + 1; i++) {
            int value = convertCharToInt(s, i - 2) * 10 + convertCharToInt(s, i - 1);
            if (value % 10 != 0 && value <= 26 && value > convertCharToInt(s, i - 1)) {
                f[i] = f[i - 1] + f[i - 2];
            } else if (value == 0) {
                // 此时索引 i-1, i-2 都为0
                return 0;
            } else if (value % 10 == 0) {
                // 此时索引  i-1 == 0
                if (value > 26) return 0;
                f[i] = f[i - 2];
            } else {
                f[i] = f[i - 1];
            }
        }
        return f[s.length()];
    }

    public static int convertCharToInt(String s, int index) {
        return s.charAt(index) - '0';
    }

    public static void main(String[] args) {
        numDecodings("230");
    }
}
