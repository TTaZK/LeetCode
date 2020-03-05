package leetcode_with_name;

import java.math.BigInteger;

public class Reverse_Integer_7 {
    // 比较简单的思路是计算出给定数字的每一位的数字，然后反转，并补充符号
    // 该方法无效，2^31 -1 = 2147483647, 但是如果用这种思路的话，需要将764...12的字符串转为int，会溢出
    // update: 针对溢出现象，题目要求返回 0; 更新之后能够正确执行，但是效率很低
    public static int reverse(int x) {
        if (x == 0) return 0;

        // prepare
        String x_str = String.valueOf(x);
        String prefix = "";
        if (x_str.startsWith("-")) {
            prefix = "-";
            x_str = x_str.substring(1, x_str.length());
        }

        // revert string
        StringBuffer x_buffer = new StringBuffer(x_str);
        String re = x_buffer.reverse().toString();
        re = re.substring(re.lastIndexOf(0) + 1, re.length());

        int result = 0;
        try {
            result = Integer.parseInt(prefix + re);
        } catch (Exception e) {
            return 0;
        }
        return result;
    }

    // 依次从个位求出当前位的数字，累计叠加
    public static int reverse_2(int x) {
        // 如果用 int 存储result，那么在 result * 10 的时候，可能就发生了溢出，导致result的值失效
        // 从而 temp 的计算结果就失效
        long result = 0;
        while (x != 0) {
            int tail = x % 10;
            // 暂时用long存储当前结果，防止溢出报错
            long temp = tail + result * 10;
            if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
                return 0;
            }
            result = temp;
            // step to next
            x = x / 10;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        //System.out.println(reverse_2(1534236469));
        //System.out.println(964632435 * 10);
    }
}
