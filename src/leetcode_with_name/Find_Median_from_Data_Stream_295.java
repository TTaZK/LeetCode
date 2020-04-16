package leetcode_with_name;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Find_Median_from_Data_Stream_295 {
    public static void main(String[] args) {
        MedianFinder1 finder = new MedianFinder1();
        finder.addNum(1);
        finder.addNum(2);
        finder.addNum(3);
        finder.addNum(4);
    }
}

class MedianFinder1 {

    // 使用堆进行时间复杂度的优化：最大堆 + 最小堆
    // 为了保证两个堆的根节点为中间节点，需要使两个堆的元素数目相等

    PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> b - a); // 最大堆
    PriorityQueue<Integer> max = new PriorityQueue<>(); // 最小堆；默认实现

    public MedianFinder1() {

    }

    public void addNum(int num) {
        // 先插入值较小的堆
        min.add(num);
        // 为了保证元素个数相差数目最大为1，需要从min中取出一个值放到max中
        max.add(min.poll());
        if (min.size() < max.size()) {
            min.add(max.poll());
        }
    }

    public double findMedian() {
        if (min.size() == max.size()) {
            return (double) (min.peek() + max.peek()) / 2;
        } else {
            return (double) min.peek();
        }
    }
}

class MedianFinder {

    // 创建一个列表，每次添加的元素有序插入列表中，时间复杂度为o(n)
    // 查询复杂度为o(1)
    // update: 插入时间复杂度还是不够好，可以使用堆进行优化
    int count = 0;
    List<Integer> array = new ArrayList<>();

    public MedianFinder() {

    }

    // 有序插入元素
    public void addNum(int num) {
        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            if (num <= array.get(i)) {
                index = i;
                break;
            }
        }
        count++;
        if (index == -1) {
            array.add(num);
        } else {
            array.add(index, num);
        }
    }

    public double findMedian() {
        int left = 0;
        int right = 0;
        if (count % 2 == 0) {
            right = count / 2;
            left = right - 1;
        } else {
            right = left = count / 2;
        }
        return (double) (array.get(left) + array.get(right)) / 2;
    }
}
