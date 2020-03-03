package problems;

public class No5 {

    // 最长回文串的长度
    int maxLength = 1;
    // 最长回文串的起始位置
    int index = 0;

    // 以某个元素为中心，向两边扩展,分别计算偶数长度的回文最大长度和奇数长度的回文最大长度
    // 在实施时，需要考虑 字符串的长度为奇数还是偶数
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        for (int i = 0; i < s.length() - 1; i++) {
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return s.substring(index, index + maxLength);
    }

    // 如果 left ==  right 则是为了应对字符串为奇数的情况
    // 如果 left + 1 == right,则是为了应对字符串为偶数的情况
    public void extend(String s, int left, int right) {
        // 从初始的left,right向两边扩展
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
        }
        // 扩展结束，记录当前的最大回文串的位置
        int now_length = right - left - 1;
        if (maxLength < now_length) {
            maxLength = now_length;
            index = left + 1;
        }
    }
}
