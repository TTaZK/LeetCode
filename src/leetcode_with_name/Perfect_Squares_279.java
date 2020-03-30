package leetcode_with_name;

public class Perfect_Squares_279 {
    // f[n] 表示最少的数目；f[n] = f[n-m] +f[m] (0 <= m <= n/2)
    // 虽然 case 全部通过了，但是超时
    public static int numSquares(int n) {
        if (n == 0) return 0;
        int[] f = new int[n + 1];
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            // 如果 i 是个完全开方数，那么f[i] = 1
            if (isSquare(i)) {
                f[i] = 1;
            }

            for (int j = 1; j <= i / 2; j++) {
                // 如果 j 是一个完全开方数，则 f[i] = f[i-j] +1
                int cur;
                if (isSquare(j)) {
                    cur = f[i - j] + 1;
                } else {
                    cur = f[i - j] + f[j];
                }
                f[i] = Math.min(cur, f[i]);
            }
        }
        return f[n];
    }

    // 耗时更少
    public static int numSquares1(int n) {
        if (n == 0) return 0;
        int[] f = new int[n + 1];
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                // 如果 j 是一个完全开方数，则 f[i] = f[i-j] +1
                // 因为对于 j ,如果其不是一个完全开方数，那么 f[i-j] +f[j] 肯定是不小于 j 是完全平方数的情况
                // 因为 f[j] >=1 肯定成立；所以在进行 0-m的遍历时，我们只需要考虑 j 为完全平方数的情况即可
                f[i] = Math.min(f[i - j * j] + 1, f[i]);
            }
        }
        return f[n];
    }

    public static boolean isSquare(int n) {
        int r = (int) Math.sqrt(n);
        return r * r == n;
    }

    public static void main(String[] args) {
        System.out.println(numSquares1(12));
    }
}
