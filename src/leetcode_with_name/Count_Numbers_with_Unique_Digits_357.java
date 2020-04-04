package leetcode_with_name;

public class Count_Numbers_with_Unique_Digits_357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += countNumbers(i);
        }
        return count;
    }

    public static int countNumbers(int n) {
        if (n > 10 || n <= 0) return 0;
        if (n == 1) return 9;
        if (n == 2) return 9 * 9;
        int sum = 9 * 9;
        int index = 8;
        while (n - 2 > 0) {
            sum = sum * index;
            index--;
            n--;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countNumbers(3) + " " + 9 * 9 * 8);
    }
}
