package test;

public class Solution1 {
    public int minCount(int[] coins) {
        int sum = 0;
        for (int count : coins) {
            int r = count % 2;
            int v = count / 2;
            v = r == 0 ? v : v + 1;
            sum += v;
        }
        return sum;
    }
}
