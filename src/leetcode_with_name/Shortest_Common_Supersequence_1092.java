package leetcode_with_name;

import java.util.*;

public class Shortest_Common_Supersequence_1092 {
    // 先求出最长公共子序列的索引位置
    // 然后将其中一个字符串的剩余字符添加到另一个字符串中
    public static String shortestCommonSupersequence(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) return "";
        // 因为同一个位置会进行多次比较，所以使用set进行去重
        Set<Integer> index1 = new HashSet<>();
        Set<Integer> index2 = new HashSet<>();
        int[][] f = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // 记录公共子序列在两个字符串中的位置
                    index1.add(i - 1);
                    index2.add(j - 1);
                }
            }
        }
        //
        // 第一个元素在str1中的位置
        int i1 = index1.iterator().next();
        int i2 = index2.iterator().next();
        // 计算出str2中其他元素相对第一个元素的位置
        List<Integer> i = new ArrayList<>();
        List<Character> iChar = new ArrayList<>();
        List<Character> s1List = new ArrayList<>();
        for (int j = 0; j < str2.length(); j++) {
            if (!index2.contains(j)) {
                i.add(j - i2);
                iChar.add(str2.charAt(j));
            }
        }
        for (char c : str1.toCharArray()) {
            s1List.add(c);
        }
        // 填充元素
        for (int j = 0; j < i.size(); j++) {
            s1List.add(i1 + j, iChar.get(j));
        }
        // 输出结果
        StringBuffer sb = new StringBuffer();
        for (char c : s1List) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        shortestCommonSupersequence("abac", "cab");
    }
}
