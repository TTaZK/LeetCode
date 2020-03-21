package leetcode_with_name;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Word_Break_139 {
    // f[i,j]能不能由指定的单词拼接取决于 f[i,k] && f[k,j]，其中k为中间位置
    // 想到了算法导论钢条切割的问题
    // f[j]表示s[0,j]能不能正确分割；f[j]=f[i] && f[i,j] ,其中 0<= i <= j
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0 || wordDict.size() == 0) return false;
        boolean[] f = new boolean[s.length() + 1];
        HashMap<String, Boolean> words = new HashMap<>();
        // init hash map
        for (String word : wordDict) {
            words.put(word, true);
        }
        f[0] = true;
        // iterator
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < j; i++) {
                String tail = s.substring(i, j);
                if (f[i] && words.get(tail) != null) {
                    f[j] = true;
                    break;
                }
            }

        }
        return f[s.length()];
    }

    public static void main(String[] args) {
        String test = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        wordBreak(test, list);
    }
}
