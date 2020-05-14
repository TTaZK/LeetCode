package leetcode_with_name;

public class Set_Matrix_Zeroes_73 {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        // to store each state of row/column
        int[] row = new int[r];
        for (int i = 0; i < r; i++) {
            row[i] = 1;
        }
        int[] col = new int[c];
        for (int j = 0; j < c; j++) {
            col[j] = 1;
        }
        // iterate
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }
        // set specific rows to zeros
        for (int i = 0; i < r; i++) {
            if (row[i] == 0) {
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // set specific columns to zeros
        for (int j = 0; j < c; j++) {
            if (col[j] == 0) {
                for (int i = 0; i < r; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
