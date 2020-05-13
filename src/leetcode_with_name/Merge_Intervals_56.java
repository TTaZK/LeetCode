package leetcode_with_name;

import java.util.*;

public class Merge_Intervals_56 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 0) {
            return new int[0][];
        }
        Stack<int[]> stack = new Stack<>();
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[1] - b[1];
        });
        stack.push(intervals[0]);
        for (int i = 1; i < n; i++) {
            int[] cur = intervals[i];
            while (!stack.isEmpty()) {
                int[] top = stack.peek();
                if (top[1] >= cur[0]) {
                    stack.pop();
                    // temp[]表示当前活动
                    int[] temp = new int[2];
                    temp[1] = cur[1];
                    temp[0] = Math.min(top[0], cur[0]);
                    cur = temp;
                    if (stack.isEmpty()) {
                        stack.push(cur);
                        break;
                    }
                } else {
                    stack.push(cur);
                    break;
                }
            }
        }
        int size = stack.size();
        int[][] result = new int[size][];
        for (int i = 0; i < size; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}
