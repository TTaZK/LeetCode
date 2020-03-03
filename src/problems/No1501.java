package problems;

import java.util.Arrays;

public class No1501 {
    public static int heightChecker(int[] heights) {
        int count = 0;
        int length = heights.length;
        if (length == 0 || length == 1) {
            return count;
        }
        int[] temp = Arrays.copyOf(heights, length);
        Arrays.sort(heights);
        for (int i = 0; i < length; i++) {
            if (temp[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        heightChecker(new int[]{1, 1, 4, 2, 1, 3});
    }
}
