package leetcode_with_name;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Word_Break_II_140 {
    // 同样类比与钢条切割
    // 只不过 f[j]不仅代表能否正确分割，还存储了切割后的字符串
    // update: 需要存储所有的切割方式，有点复杂，暂时放弃
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0 || wordDict.size() == 0) return new ArrayList<>();
        HashMap<String, Boolean> words = new HashMap<>();
        // init hash map
        for (String word : wordDict) {
            words.put(word, true);
        }
        ArrayList[] f = new ArrayList[s.length() + 1];
        f[0] = new ArrayList(); // != null
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < j; i++) {
                String tail = s.substring(i, j);
                if (f[i] != null && words.get(tail) != null) {

                }
            }
        }
        return null;
    }
}
