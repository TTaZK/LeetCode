package leetcode_with_name;

public class Container_With_Most_Water_11 {
    // before
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int[] temp = new int[height.length];
        while (i < j) {
            if (height[i] < height[j]) {
                temp[i] = height[i] * (j - i);
                i++;
            } else {
                temp[j] = height[j] * (j - i);
                j--;
            }
        }
        int max = temp[0];
        for (int a : temp) {
            max = max > a ? max : a;
        }
        return max;
    }

    // rewrite
    // Start by evaluating the widest container, using the first and the last line.
    // All other possible containers are less wide, so to hold more water, they need to be higher.
    // Thus, after evaluating that widest container, skip lines at both ends that don't support a higher height.
    // Then evaluate that new container we arrived at. Repeat until there are no more possible containers left.
    public int maxArea1(int[] height) {
        if (height.length == 0) return 0;
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
