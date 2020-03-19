package leetcode_with_name;

public class Maximal_Square_221 {
    //    dp[i][j] represents the length of the square which lower right corner is located at (i, j).
//    If the value of this cell is also 1, then the length of the square is the minimum of: the one above, its left, and diagonal up-left value +1. Because if one side is short or missing, it will not form a square.
    public int maximalSquare(char[][] matrix) {
        if (matrix.length <= 0) return 0;
        int[][] f = new int[matrix.length + 1][matrix[0].length + 1];
        int length = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    // 如果某一位置为0，则以该位置为正方形的边长为0
                    // 所以在当前位置为1的情况下，需要判断其上，左，左上位置是否为0；取最小值就是在上述三个位置中只要有一个为0
                    // 那么 f[i,j] = 0+1 = 1;如果三个位置都不为0，则f[i,j] > 1
                    f[i][j] = Math.min(Math.min(f[i - 1][j], f[i][j - 1]), f[i - 1][j - 1]) + 1;
                    length = Math.max(length, f[i][j]);
                } else {
                    // 可以忽略
                    f[i][j] = 0;
                }
            }
        }
        return length * length;
    }
}
