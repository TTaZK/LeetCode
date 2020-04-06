package leetcode_with_name;

import java.util.*;

public class Group_Anagrams_49 {
    // 首先想到的方法是先求出指定字符串的所有全排列，然后对原数组进行遍历
    // 思路及答案没问题，但是如果输入的字符串太长，会导致超时
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        List<String> t = new ArrayList<>();
        for (String s : strs) {
            t.add(s);
        }
        while (!t.isEmpty()) {
            String s = t.get(0);
            Map<String, Boolean> map = arrangement(s);
            List<String> group = new ArrayList<>();
            for (int i = 0; i < t.size(); i++) {
                if (map.get(t.get(i)) != null) {
                    group.add(t.get(i));
                }
            }
            for (String remove : group) {
                t.remove(remove);
            }
            res.add(group);
        }
        return res;
    }

    public Map<String, Boolean> arrangement(String input) {
        char[] array = input.toCharArray();
        List<String> res = new ArrayList<>();
        Map<String, Boolean> map = new HashMap<>();
        backTrack(0, array, res);
        for (String s : res) {
            map.put(s, true);
        }
        return map;
    }

    // 回溯法求出输入字符串的全排列
    public void backTrack(int level, char[] input, List<String> res) {
        if (level >= input.length) {
            res.add(new String(input));
        } else {
            // 当前层可以取的值
            for (int i = level; i < input.length; i++) {
                swap(input, level, i);
                backTrack(level + 1, input, res);
                swap(input, level, i);
            }
        }
    }

    public void swap(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    // ac
    public List<List<String>> groupAnagrams1(String[] strs) {
        // 用于存储同一组字符串
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(s);
            map.put(key, list);
        }
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}
