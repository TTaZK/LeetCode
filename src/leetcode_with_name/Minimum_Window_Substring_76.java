package leetcode_with_name;

import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_Substring_76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int counter = t.length();
        int start, end, size, minStart, minLength;
        start = end = minStart = 0;
        size = s.length();
        minLength = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        // init
        for (Character c : t.toCharArray()) {
            Integer value = map.get(c);
            if (value == null) {
                map.putIfAbsent(c, 1);
            } else {
                map.put(c, value + 1);
            }
        }
        // find valid substring
        while (end < size) {
            Character c = s.charAt(end);
            Integer value = map.get(c);
            if (value != null) {
                if (value > 0) {
                    counter--;
                }
                // find a char that t exists
                int v = value;
                map.put(c, --v);
            }
            if (value == null || value == 0) {
                map.put(c, -1);
            }
            end++;
            // valid substring
            while (counter == 0) {
                // 此时map中各个char对应的值就是：当前位置之前s中该元素的数量比t中多的数目
                int curLength = end - start;
                if (curLength < minLength) {
                    minLength = curLength;
                    minStart = start;
                }
                // minify window
                char ch = s.charAt(start);
                Integer vl = map.get(ch);
                map.put(ch, ++vl);

                if (vl > 0) {
                    counter++;
                }
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
