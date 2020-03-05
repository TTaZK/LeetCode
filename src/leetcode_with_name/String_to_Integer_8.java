package leetcode_with_name;

public class String_to_Integer_8 {
    public static int myAtoi(String str) {
        long result = 0;
        if (str.equals("")) return (int) result;

        int nonSpaceFlag = 0;
        int sign = 1;
        for (char c : str.toCharArray()) {
            if (c == ' ') continue;
            if (!isDigital(c)) {
                if (result != 0) {
                    break;
                } else if (nonSpaceFlag == 0) {
                    // go ahead
                } else {
                    continue;
                }
            }

            // 不是以有效字符开始
            if (!(c == '-' || c == '+') && !isDigital(c) && nonSpaceFlag == 0) return 0;

            // 确定符号
            if (c == '-' && nonSpaceFlag == 0) {
                sign = -1;
                nonSpaceFlag = 1;
                continue;
            } else if (c == '+' && nonSpaceFlag == 0) {
                sign = 1;
                nonSpaceFlag = 1;
                continue;
            } else if ((c == '-' || c == '+') && nonSpaceFlag != 0) {
                continue;
            }

            nonSpaceFlag = 1;

            int cur = c - '0';
            result = result * 10 + cur;
            if (result > Integer.MAX_VALUE && sign == 1) {
                result = Integer.MAX_VALUE;
                break;
            } else if (-1 * result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return sign * (int) result;
    }

    public static boolean isDigital(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("+-2"));
    }
}
