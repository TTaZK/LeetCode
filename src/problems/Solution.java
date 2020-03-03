package problems;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int index = 0;
        int count = 1;
        Set<Integer> indexs = new HashSet<>();
        indexs.add(index);
        while ((index = nextIndex(A, index)) != -1) {
            if (indexs.contains(index)) return count;
            indexs.add(index);
            count++;
        }
        return count;
    }

    public int nextIndex(int[] A, int index) {
        return A[index];
    }

    public static void main(String[] args) {
        int ans = new Solution().solution(new int[]{
                1,2,3,4,1
        });
        System.out.println(ans);
    }
}
