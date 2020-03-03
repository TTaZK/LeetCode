package problems;

import java.util.ArrayList;
import java.util.List;

public class No17_2 {
    // 采用回溯算法
    // 解空间为排列树
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
                // 从根节点到level层的路径取值为：now_value
                now_value = now_value + i;
                letterCombinations(input, level + 1, now_value, result);
                // 恢复当前层的原始值
                now_value = now_value.substring(0, now_value.length() - 1);
            }
        }
        return result;
    }
}
