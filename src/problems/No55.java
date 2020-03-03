package problems;

public class No55 {
    public boolean canJump1(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                if (i == 0) {
                    return false;
                } else {
                    if (nums[i - 1] < 2) {
                        return false;
                    }
                    continue;
                }
            }
        }
        return true;
    }

    // 对数组倒序遍历，记录0的个数
    public static boolean canJump2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        int zeroCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                zeroCount++;
                if (i == 0) {
                    return false;
                }
            } else {
                if (nums[i] > zeroCount) {
                    zeroCount = 0;
                } else if (i == 0 && n - 1 == zeroCount && nums[i] == zeroCount) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean canJump(int[] nums) {
        // reachable字段用于记录在该索引及之前的索引中，所能跳到的最远的索引位置
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, nums[i] + i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {2, 0, 0};
        System.out.println(canJump(array));
    }
}
