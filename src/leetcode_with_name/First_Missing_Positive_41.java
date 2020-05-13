package leetcode_with_name;

import java.util.ArrayList;
import java.util.List;

public class First_Missing_Positive_41 {
    // before
    public int firstMissingPositive(int[] nums) {
        MonotonousQueue queue = new MonotonousQueue();
        for (int value : nums) {
            if (value <= 0) continue;
            queue.push(value);
        }
        if (queue.size() == 0 || queue.get(queue.size() - 1) > 1) return 1;
        int v = queue.get(0);
        for (int i = queue.size() - 2; i >= 0; i--) {
            if (queue.get(i) >= queue.get(i + 1) + 2) {
                v = queue.get(i + 1);
                break;
            }
        }
        return v == 1 ? 2 : v + 1;

    }

    // 参考单调队列的思想
    // 维护一个正数的单调递减队列
    class MonotonousQueue {
        List<Integer> list = new ArrayList<>();

        public void push(int value) {
            if (list.isEmpty() || list.get(list.size() - 1) >= value) {
                list.add(value);
                return;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) <= value) {
                    list.add(i, value);
                    return;
                }
            }
        }

        public int size() {
            return list.size();
        }

        public int get(int index) {
            return list.get(index);
        }
        // Delete and return the top element of queue
//        public int pop() {
//
//        }
    }
}
