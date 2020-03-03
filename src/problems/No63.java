package problems;

public class No63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] f = new int[row][column];

        if (obstacleGrid[0][0] == 1) f[0][0] = 0;
        f[0][0] = 1;
        for (int i = 1; i < column; i++) {
            f[0][i] = (f[0][i - 1] == 1 && obstacleGrid[0][i] == 0) ? 1 : 0;
        }
        for (int i = 1; i < row; i++) {
            f[i][0] = (f[i - 1][0] == 1 && obstacleGrid[i][0] == 0) ? 1 : 0;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                    continue;
                }
                // 对于该做法的想法是：
                // 对于某一节点[i,j]，它的取值由[i-1,j],[i,j-1]的取值决定的
                // 如果[i-1,j]位置的值为1，那么[i,j]只能由左面进入，则[i,j] = [i,j-1]
                // 如果[i,j-1]位置的值为1，那么[i,j]只能由上面进入，则[i,j] = [i-1,j]
                // 如果[i,j-1],[i-1,j]位置的值为1，那么[i,j]无法进入，则[i,j] = 0
                // 但是测试用例无法全部通过
                // 不通过的原因找到了，对第一行第一列进行初始化时，出现了错误
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

    // 官方给的答案中描述
    // 对于节点[i,j]，如果该节点的值为0，那么[i,j] = [i-1,j]+[i,j-1]
    // 否则,[i,j]=0

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {

        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        // Filling the values for the first column
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        // Return value stored in rightmost bottommost cell. That is the destination.
        return obstacleGrid[R - 1][C - 1];
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int a = uniquePathsWithObstacles(nums);
        System.out.println(a);
    }
}
