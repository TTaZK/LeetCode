package problems;

public class No1502 {
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        if (customers.length <= 0 || grumpy.length <= 0) {
            return 0;
        }
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 1) {
                customers[i] = 0 - customers[i];
            }
        }
        // 用于记录每种情况下的数组和
        int[] sums = new int[customers.length + 1 - X];
        int sum = 0;
        int maxSum = 0;
        for (int i : customers) {
            sum += i;
        }
        maxSum = sum;
        int lastSubSum = 0;
        int nowSubSum = 0;
        for (int i = 0; i < X; i++) {
            lastSubSum += customers[i];
        }
        for (int i = 0; i < customers.length + 1 - X; i++) {
            int start = i;
            int last = start + X;
            for (int j = start; j < last; j++) {
                if (customers[j] < 0)
                    nowSubSum = nowSubSum - customers[j];
                else
                    nowSubSum += customers[j];
            }
            if (i == 0) {
                sums[i] = sum + (nowSubSum - lastSubSum);
            } else {
                sums[i] = sums[i - 1] + (nowSubSum - lastSubSum);
            }
            lastSubSum = nowSubSum;
            nowSubSum = 0;
        }
        for (int s : sums) {
            maxSum = maxSum > s ? maxSum : s;
        }
        return maxSum;
    }

    public static int maxSatisfied1(int[] customers, int[] grumpy, int X) {
        if (customers.length <= 0 || grumpy.length <= 0) {
            return 0;
        }
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 1) {
                customers[i] = 0 - customers[i];
            }
        }
        int[] sums = new int[customers.length + 1 - X];
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (i < X && customers[i] < 0) {
                sum -= customers[i];
            } else {
                sum += customers[i];
            }
        }
        sums[0] = sum;

        for (int i = 1; i < customers.length + 1 - X; i++) {
            int start = i;
            int last = start + X - 1;
            int sub = (customers[start - 1] - Math.abs(customers[start - 1])) + (Math.abs(customers[last]) - customers[last]);
            sums[i] = sums[i - 1] + sub;
        }
        for (int s : sums) {
            maxSum = maxSum > s ? maxSum : s;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSatisfied1(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }
}
