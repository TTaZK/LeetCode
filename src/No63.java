public class No63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] f = new int[row][column];
        f[0][0] = 1;
        // 记录第一行每个位置的路径数
        // 如果存在某个位置为1，那么该位置之后的所有可达路径都为0
        int index_row = -1, index_column = -1;
        for (int i = 0; i < column; i++) {
            if (obstacleGrid[0][i] == 1) {
                index_row = i;
                break;
            }
            f[0][i] = 1;
        }
        if (index_row >= 0) {
            for (int i = index_row; i < column; i++) {
                f[0][i] = 0;
            }
        }
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                index_column = i;
            }
            f[i][0] = 1;
        }
        if (index_column >= 0) {
            for (int i = index_column; i < row; i++) {
                f[i][0] = 0;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                    continue;
                }
                if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 0) {
                    f[i][j] = f[i][j - 1];
                } else if (obstacleGrid[i - 1][j] == 0 && obstacleGrid[i][j - 1] == 1) {
                    f[i][j] = f[i - 1][j];
                } else if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1) {
                    f[i][j] = 0;
                } else if (obstacleGrid[i - 1][j] == 0 && obstacleGrid[i][j - 1] == 0) {
                    f[i][j] = f[i][j - 1] + f[i - 1][j];
                }
            }
        }
        return f[row - 1][column - 1];
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int a = uniquePathsWithObstacles(nums);
        System.out.println(a);
    }
}
