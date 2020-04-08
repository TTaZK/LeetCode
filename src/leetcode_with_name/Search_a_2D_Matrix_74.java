package leetcode_with_name;

public class Search_a_2D_Matrix_74 {
    // 可以直接采用II的方法，从矩阵的右上角往左下角遍历
    // 但是也可以考虑用二分查找，因为整个矩阵是递增的
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n <= 0) return false;
        int m = matrix[0].length;
        if (m <= 0) return false;

        // 先确定target再矩阵中的哪一行
        // 根据每一行最后一个元素判断
        int row = 0;
        while (matrix[row][m - 1] < target) {
            row++;
            if (row >= n) return false;
        }
        // 二分查找确定列
        int begin = 0;
        int end = m;
        while (begin <= end) {
            int middle = (end - begin) / 2;
            if (matrix[row][middle] == target) return true;
            else if (matrix[row][middle] > target) {
                end = middle - 1;
            } else {
                begin = middle + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 13;
        searchMatrix(array, target);
    }
}
