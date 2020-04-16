package leetcode_with_name;

public class Find_Peak_Element_162 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            int pre, next;
            // 确定前面的元素
            if (i == 0) pre = Integer.MIN_VALUE;
            else pre = nums[i - 1];
            // 确定后面的元素
            if (i == nums.length - 1) next = Integer.MIN_VALUE;
            else next = nums[i + 1];
            // compare
            if (nums[i] > pre && nums[i] > next) return i;
        }
        return 0;
    }

    // 讨论中存在使用二分查找的方式
    // Most people have figured out the binary search solution but are not able to understand how its working.
    // I will try to explain it simply.
    // What we are essentially doing is going in the direction of the rising slope(by choosing the element which is greater than current).
    // How does that guarantee the result? Think about it, there are 2 possibilities.a) rising slope has to keep rising till end of the array b) rising slope will encounter a lesser element and go down.
    // In both scenarios we will have an answer. In a) the answer is the end element because we take the boundary as -INFINITY b) the answer is the largest element before the slope falls. Hope this makes things clearer.
    public int findPeakElement1(int[] nums) {
        // 我们需要找到的是上升与下降的交界
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            int midNext = mid + 1;
            // 当前阶段还是处于上升阶段；那么需要继续找到上升的终点
            if (nums[mid] < nums[midNext]) {
                low = midNext;
            } else {
                // 当前阶段处于下降阶段；那么需要往前找到上升阶段
                high = mid;
            }
        }
        return low;
    }
}
