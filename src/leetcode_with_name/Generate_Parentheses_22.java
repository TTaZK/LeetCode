package leetcode_with_name;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Generate_Parentheses_22 {
    // 使用回溯求出所有可能的解，之后进行判断
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        return generateParenthesis(n * 2, 0, "", result);
    }

    public List<String> generateParenthesis(int n, int level, String now, List<String> result) {
        if (level >= n) {
            if (isValid(now)) {
                result.add(now);
            }
        } else {
            // 当前层的取值有两种：( ，）
            // 先取（
            now = now + "(";
            generateParenthesis(n, level + 1, now, result);
            now = now.substring(0, now.length() - 1);

            // 再取 ）
            now = now + ")";
            generateParenthesis(n, level + 1, now, result);
            now = now.substring(0, now.length() - 1);
        }
        return result;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.peek();
                    if (top == '(') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
