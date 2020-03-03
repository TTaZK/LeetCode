package problems;

import java.util.*;

public class No49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        List<Set<String>> fullPermutation = new ArrayList<>();
        for (String string : strs) {
            if (fullPermutation.isEmpty()) {
                Set<String> set = fullPermutation(string);
                fullPermutation.add(set);
                List<String> list = new ArrayList<>();
                list.add(string);
                ans.add(list);
            }
        }
        return null;
    }


    // 该题的本来求法是对于输入的数组，计算每个字符串的全排列
    public Set<String> fullPermutation(String input) {
        Set<String> ans = new HashSet<>();
        if (input.length() <= 0) {
            return ans;
        }
        return fullPermutation(input, 0, ans);
    }

    public Set<String> fullPermutation(String input, int level, Set<String> ans) {
        if (level >= input.length()) {
            ans.add(input);
        } else {
            for (int i = level; i < input.length(); i++) {
                input = swap(input, level, i);
                fullPermutation(input, level + 1, ans);
                input = swap(input, level, i);
            }
        }
        return ans;
    }

    public String swap(String input, int i, int j) {
        char[] array = input.toCharArray();
        char a = array[i];
        array[i] = array[j];
        array[j] = a;
        return new String(array);
    }

    public static void main(String[] args) {
        Set<String> ans = new No49().fullPermutation("eat");
        Iterator<String> iterator = ans.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
