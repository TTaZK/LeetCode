package leetcode_with_name;

import java.util.Stack;

public class Valid_Parentheses_20 {
    // before
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(' || temp == '[' || temp == '{') {
                stack.push(temp);
            } else {
                if (stack.empty()) {
                    // 如果先入队的是),],}，那么肯定不能进行匹配
                    return false;
                }
                char top = stack.peek();
                if (match(temp, top)) {
                    stack.pop();
                } else {
                    stack.push(temp);
                }
            }
        }
        return stack.size() == 0 ? true : false;
    }

    public boolean match(char a, char b) {
        if ((a == ')' && b == '(') || (a == ']' && b == '[') || (a == '}' && b == '{')) {
            return true;
        }
        return false;
    }
}
