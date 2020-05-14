package leetcode_with_name;

public class Rotate_Image_48 {
    // 先将矩阵的行进行调换
    // 然后再依次交换对角线的值
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length - 1 - i];
            matrix[matrix.length - 1 - i] = temp;
        }
        swap(matrix);
    }

    // 交换对角线值
    public void swap(int[][] martix) {
        for (int i = 0; i < martix.length; i++) {
            for (int j = 0; j < i; j++) {
                if (i != j) {
                    int temp = martix[i][j];
                    martix[i][j] = martix[j][i];
                    martix[j][i] = temp;
                }
            }
        }
    }
}
