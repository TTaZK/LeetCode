package leetcode_with_name;

public class Valid_Palindrome_125 {
    // 有两种思路：1. 先将原字符串中的无效字符过滤掉，然后反转新的字符串得到B，再将原字符串与B比较，相等则是回文
    // 2. 使用首尾指针，从两端向中间遍历并比较
    public static boolean isPalindrome(String s) {
        if (s == "") return true;
        int head, tail, sub;
        head = 0;
        tail = s.length() - 1;
        sub = 'A' - 'a';
        while (head <= tail) {
            char headChar = s.charAt(head);
            char tailChar = s.charAt(tail);
            if (isUsefulCharacter(headChar) && isUsefulCharacter(tailChar)) {
                if (headChar == tailChar || (isCharacter(headChar) && isCharacter(tailChar) && (headChar + sub == tailChar || headChar - sub == tailChar))) {
                    head++;
                    tail--;
                    continue;
                }
                return false;
            } else if (!isUsefulCharacter(headChar)) head++;
            else if (!isUsefulCharacter(tailChar)) tail--;
        }
        return true;
    }

    public static boolean isUsefulCharacter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public static boolean isCharacter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }
}
