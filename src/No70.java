public class No70 {
    // 斐波那契数
    // f[n] = f[n-1] + f[n-2]
    public static int climbStairs(int n) {
        if (n <= 1) return 1;
        int[] f = new int[n];
        // init
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
