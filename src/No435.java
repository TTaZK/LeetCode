import java.util.Arrays;

public class No435 {
    // 活动选择问题，每次选取最早结束的活动，求最大的兼容活动数量
    // 活动数量求出来之后，用总长度减去即得到需要移除的数量
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });
        // k用于记录满足当前活动兼容的活动下标
        int k = 0, count = 1, n = intervals.length;
        if (n <= 0) return 0;
        for (int i = 1; i < n; i++) {
            // 如果第i个活动的开始时间大于第k个活动的结束时间，则这两个活动兼容
            // 将当前活动加入集合中
            if (intervals[i][0] >= intervals[k][1]) {
                count++;
                k = i;
            }
        }
        return n - count;
    }
}
