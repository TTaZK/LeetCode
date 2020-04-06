package leetcode_with_name;

public class Counting_Bits_338 {
    // 这个题目关键点在于求一个数二进制表达式中1的个数
    // 参考编程之美
    // n & (n-1) 可以去除n的末尾1
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = count(i);
        }
        return res;
    }

    public int count(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
