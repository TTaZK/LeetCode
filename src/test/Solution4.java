package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution4 {
    public static void main(String[] args) {
        int[] jump = new int[]{2, 3, 2,1};
        minJump(jump);
    }

    // 采用回溯法
    public static int minJump(int[] jump) {
        if (jump == null || jump.length == 0) return 0;
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        jump(jump, 0, 0, ans, set);
        int min = Integer.MAX_VALUE;
        for (int count : ans) {
            System.out.println(count);
            min = Math.min(min, count);
        }
        return min;
    }

    public static void jump(int[] jump, int curIndex, int curCount, List<Integer> ans, Set<Integer> index) {
        if (curIndex > jump.length - 1) {
            ans.add(curCount);
        } else {
            int v = jump[curIndex];
            // 往右跳
            if (!index.contains(curIndex + v)) {
                if (curIndex + v <= jump.length - 1) {
                    index.add(curIndex + v);
                }
                jump(jump, curIndex + v, curCount + 1, ans, index);
            }

            // 往左跳
            for (int i = curIndex - 1; i >= 0 && i >= curIndex - v; i--) {
                if (!index.contains(i)) {
                    if (curIndex + v < jump.length - 1) {
                        index.add(i);
                    }
                    jump(jump, i, curCount + 1, ans, index);
                }
            }
        }
    }
}
