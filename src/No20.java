import java.util.Stack;

public class No20 {
    public static boolean isValid(String str) {
        if (str.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
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

    public static boolean match(char a, char b) {
        if ((a == ')' && b == '(') || (a == ']' && b == '[') || (a == '}' && b == '{')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("(()[][[]{})"));
    }
}
