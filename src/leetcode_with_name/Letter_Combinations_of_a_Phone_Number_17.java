package leetcode_with_name;

import java.util.*;

public class Letter_Combinations_of_a_Phone_Number_17 {
    // before
    // 回溯：类似于全排列
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        List<String> input = new ArrayList<>();
        if (digits.length() <= 0) {
            return ans;
        }
        for (char c : digits.toCharArray()) {
            String meta = "";
            if (c == '2') {
                meta = "abc";
            } else if (c == '3') {
                meta = "def";
            } else if (c == '4') {
                meta = "ghi";
            } else if (c == '5') {
                meta = "jkl";
            } else if (c == '6') {
                meta = "mno";
            } else if (c == '7') {
                meta = "pqrs";
            } else if (c == '8') {
                meta = "tuv";
            } else if (c == '9') {
                meta = "wxyz";
            }
            input.add(meta);
        }
        return letterCombinations(input, 0, "", ans);
    }

    /**
     * 回溯
     *
     * @param input     输入
     * @param level     当前层数
     * @param now_value 当前层的取值
     * @param result    输出结果
     * @return
     */
    public static List<String> letterCombinations(List<String> input, int level, String now_value, List<String> result) {
        int n = input.size();
        if (level >= n) {
            result.add(now_value);
        } else {
            for (char i : input.get(level).toCharArray()) {
                // 当前层可能的取值
                now_value = now_value + i;
                letterCombinations(input, level + 1, now_value, result);
                // 恢复当前层的原始值
                now_value = now_value.substring(0, now_value.length() - 1);
            }
        }
        return result;
    }
}
