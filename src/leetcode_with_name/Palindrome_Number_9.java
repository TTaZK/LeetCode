package leetcode_with_name;

public class Palindrome_Number_9 {
    // 虽然测试通过了，但是没有考虑在求反转数值时可能溢出的场景
    public static boolean isPalindrome(int x) {
        // 负数不是回文数
        if (x < 0) return false;
        // 正数先确定其反过来的数值
        int reverseNum = 0;
        int temp = x;
        while (x != 0) {
            int tail = x % 10;
            reverseNum = reverseNum * 10 + tail;
            x = x / 10;
        }
        return reverseNum == temp;
    }


    // 高赞答案
    // compare half of the digits in x, so don't need to deal with overflow.
    public boolean isPalindrome_2(int x) {
        // 负数 & 尾数为0并且非0的数 不是回文数
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        // 比较后半段与前半段的大小，直到后半段不小于前半段
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        // 如果是回文数字，存在两种情况：1. 数字位数为偶数，前后两半段相等；2. 数字位数为奇数，除去中间位数，前后半段相等
        return (x == rev || x == rev / 10);
    }

    // 模仿高赞code
    public boolean isPalindrome_3(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) return false;
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return x == reverse || x == reverse / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
