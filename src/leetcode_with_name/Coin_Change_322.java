package leetcode_with_name;

public class Coin_Change_322 {
    // 类似与完全背包问题
    // f[i][j] 表示在总额为j，可选硬币种类为i的情况下，所需要的最少硬币个数
    // f[i][j]=min{f[i-1][j-k*coins[i]]+k},其中 0<=k<=j/value[i]
    // 下面代码not ac
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) return -1;
        int[][] f = new int[coins.length + 1][amount + 1];
        // init
        for (int i = 0; i < coins.length + 1; i++) {
            f[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < amount + 1; i++) {
            f[0][i] = Integer.MAX_VALUE;
        }
        //
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                // 第i种硬币最多可选个数
                int k = j / coins[i - 1];
                for (int l = 0; l <= k; l++) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - l * coins[i - 1]] + l);
                }
            }
        }
        return f[coins.length][amount] == 0 ? -1 : f[coins.length][amount];
    }

    // 在 0/1 背包问题中
    // 第i次循环中的状态f[i][v]是由状态f[i-1][v-c[i]]递推而来。换句话说，这正是为了保证每件物品只选一次，保证在考虑“选入第i件物品”这件策略时，依据的是一个绝无已经选入第i件物品的子结果f[i-1][v-c[i]]。
    // 而现在完全背包的特点恰是每种物品可选无限件，所以在考虑“加选一件第i种物品”这种策略时，却正需要一个可能已选入第i种物品的子结果f[i][v-c[i]]；此时f[i][v]=max{f[i-1][v],f[i][v-c[i]]+w[i]}
    // https://www.kancloud.cn/kancloud/pack/70126
    // 结合完全背包的优化思路，可以对找零钱问题进行同样的优化
    // f[i][j]=min( f[i－1][ j ], f [i ] [ j - value[i] ] + 1) ，注意后面是f[i, j-value[i]]，i 没有减1
    // 可以抽象成一维数组 f[v]=min{f[v],f[v-c[i]]+w[i]}
    // 下面的二维数组实现没有ac
    public int coinChange2(int[] coins, int amount) {
        if (amount <= 0) return -1;
        int[][] f = new int[coins.length + 1][amount + 1];
        // init
        for (int i = 0; i < coins.length + 1; i++) {
            f[i][0] = 0;
        }
        for (int i = 0; i < amount + 1; i++) {
            f[0][i] = Integer.MAX_VALUE;
        }
        //
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j < coins[i - 1]) {
                    f[i][j] = f[i - 1][j];
                } else {
                    if (f[i][j - coins[i - 1]] == Integer.MAX_VALUE) {
                        f[i][j] = Integer.MAX_VALUE;
                    } else {
                        f[i][j] = Math.min(f[i - 1][j], f[i][j - coins[i - 1]] + 1);
                    }
                }
            }
        }
        return f[coins.length][amount] == Integer.MAX_VALUE ? -1 : f[coins.length][amount];
    }

    // f[j] = min{f[j],f[j-c[i]]+1}
    public int coinChange3(int[] coins, int amount) {
        if (amount <= 0) return 0;
        int[] f = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            // 默认不能找零
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= coins.length; j++) {
                // 总钱数大于当前硬币面额 && 如果换了当前硬币之后能够成功找零
                if (i >= coins[j - 1] && f[i - coins[j - 1]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i], f[i - coins[j - 1]] + 1);
                }
            }
        }
        if (f[amount] == Integer.MAX_VALUE)
            return -1;
        else
            return f[amount];

    }
}
