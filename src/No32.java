import java.util.Stack;

public class No32 {
    public int longestValidParentheses1(String s) {
        int max = 0;
        if (s.length() == 0) {
            return max;
        }
        int n = s.length();
        int[] f = new int[n];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char temp = s.charAt(i);
            if (temp == '(') {
                stack.push(temp);
            } else {
                // 如果此时字符为')'并且栈为空，那么该字符将不能进行匹配
                // 记录当前字符的索引位置
                if (stack.empty()) {
                    stack.push(temp);
                    f[i] = 1;
                    continue;
                }
                char top = stack.peek();
                if (top == '(' && temp == ')') {
                    stack.pop();
                } else {
                    // 如果此时字符为')'但是栈顶元素不为'(',那么该字符也将不能进行匹配
                    // 记录当前字符的索引位置
                    stack.push(temp);
                    f[i] = 1;
                }
            }
        }
        // 对于f[]数组，如果某一位置的值不为0，那么说明该位置为匹配间断点
        // 找出最长的间断距离，也就是最长的有效距离
        for (int i : f) {
            max = max < i ? i : max;
        }
        return max;
    }

    // 上面的方法想要找出字符串的间断点，但是没有找到好的思路
    // 该方法使用栈存储每个字符的索引位置，而不是具体的字符
    // 当字符串遍历完成后，栈中剩余的索引位置就是间断点的索引值
    public int longestValidParentheses(String s) {
        int max = 0;
        if (s.length() == 0) {
            return max;
        }
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char temp = s.charAt(i);
            if (temp == '(') {
                stack.push(i);
            } else {
                if (stack.empty()) {
                    stack.push(i);
                    continue;
                }
                char top = s.charAt(stack.peek());
                if (top == '(' && temp == ')') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        if (stack.empty()) {
            max = n;
        } else {
            int a = n;
            int b = stack.pop();
            while (a > 0 && a > b) {
                max = (a - b) > max ? a - b : max;
                a = b;
                b = stack.empty() ? -1 : stack.pop();
            }
            max--;
        }
        return max;
    }
}
