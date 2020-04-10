package leetcode_with_name;

import java.util.List;
import java.util.Objects;

public class Palindromic_Substrings_647 {
    // 比较简单的方法是先求出该字符串的所有子串
    // 然后再找出回文子串
    // 用回溯法求出的子串不是索引位置连续的子串，不符合题目的要求
    // 本地测试数据没问题，但是leetcode测试结果与本地不一致
    public static int countSubstrings(String s) {
        backTrack(s, 0, "", -1, -1);
        return count;
    }

    static int count = 0;

    // 因为要求是连续位置的子串，那么使用index记录子串中第一个字符的位置
    // 当遍历至子集树的叶子节点时，比较当前子串的长度与level - index
    // 如果相等，子串的索引位置连续 ---> 也不行，
    // update:
    // 如果只记录子串的起始位置，level - index 不能准确记录子串的长度
    // 因此使用两个索引分别记录子串的起始位置及结束位置
    public static void backTrack(String s, int level, String cur, int start, int end) {
        if (level >= s.length()) {
            // 不能写成 level >= s.length() && isPalindromic(cur) 不然代码不会进入到该语句块中
            if (end - start + 1 == cur.length() && isPalindromic(cur)) {
                // System.out.println(cur);
                count++;
            }
        } else {
            // not add
            backTrack(s, level + 1, cur, start, end);
            // add
            if (start == -1) start = level;
            // 因为此时子串又添加了新的元素，所以结束位置需要更新
            end = level;
            String sub = cur + s.charAt(level);
            backTrack(s, level + 1, sub, start, end);
        }
    }

    public static boolean isPalindromic(String s) {
        if (s.length() == 0) return false;
        int head = 0;
        int tail = s.length() - 1;
        while (head <= tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }

    // 参考评论，从指定索引位置向两边遍历
    public static int countSubstrings1(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // 回文子串可能为奇数
            count += travel(s, i, i);
            // 回文子串可能为偶数
            count += travel(s, i, i + 1);
        }
        return count;

    }

    public static int travel(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(countSubstrings1("aaa"));
        System.out.println(count);
    }
}
