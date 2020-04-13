package leetcode_with_name;

import javax.print.MultiDocPrintService;

public class Word_Search_79 {
    public boolean exist(char[][] board, String word) {
        // 用于标识当前位置是否已经被遍历过
        int[][] used = new int[board.length][board[0].length];
        return travel(board, used, 0, 0, word.toCharArray(), 0);
    }

    // [i,j] 表示当前位置，k 表示在目标数组中的位置
    // 采用类似回溯+分支裁剪
    public boolean travel(char[][] board, int[][] used, int i, int j, char[] target, int k) {
        if (k >= target.length) {
            return true;
        } else {
            if (isAvailable(board, used, i, j, target[k])) {
                used[i][j] = 1;
                // 遍历当前位置的四个方向
                return travel(board, used, i, j + 1, target, k + 1) ||
                        travel(board, used, i + 1, j, target, k + 1) ||
                        travel(board, used, i, j - 1, target, k + 1) ||
                        travel(board, used, i - 1, j, target, k + 1);
            } else {
                if (k == 0) {
                    return travel(board, used, i, j + 1, target, k) ||
                            travel(board, used, i + 1, j, target, k);
                } else {
                    return false;
                }
            }
        }
    }

    public boolean isAvailable(char[][] board, int[][] used, int i, int j, char c) {
        // [i,j] 表示当前位置，c 表示当前元素
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0) return false;
        return board[i][j] == c && used[i][j] == 0;
    }
}
