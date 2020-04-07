package leetcode_with_name;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Anagrams_in_a_String_438 {

    // 可以从index = 0遍历s，截取指定长度的子字符串，判断两个是否为同字母异序的单词
    // 时间复杂度为 o(n*m)
    // 效率比较低
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int length = p.length();
        for (int i = 0; i <= s.length() - length; i++) {
            String sub = s.substring(i, length + i);
            if (isAnagram(sub, p)) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean isAnagram(String s, String t) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            counts[c - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) {
                // 说明个数不一致
                return false;
            }
        }
        return true;
    }
}
