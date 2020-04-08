package leetcode_with_name;

public class Search_a_2D_Matrix_II_240 {
    // 从矩阵的右上角开始往左下角遍历
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length; // row
        if (n <= 0) return false;
        int m = matrix[0].length; // column
        if (m <= 0) return false;
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }

        }
        return false;
    }
}
