import java.util.HashMap;
import java.util.Map;

public class No860 {
    // 对传入的数组进行遍历，如果当前元素为5，放入map中；
    // 如果为10，那么从map中取出一个5，并放入10；对20做类似的操作
    public static boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> collection = new HashMap<>();
        collection.put(5, 0);
        collection.put(10, 0);
        for (int bill : bills) {
            int count_5 = collection.get(5);
            int count_10 = collection.get(10);
            switch (bill) {
                case 5:
                    collection.put(5, count_5 + 1);
                    break;
                case 10:
                    if (count_5 <= 0) return false;
                    collection.put(5, count_5 - 1);
                    collection.put(10, count_10 + 1);
                    break;
                case 20:
                    if (count_5 <= 0 && count_10 <= 0) return false;
                    if(count_5 <= 0) return false;
                    if(count_10 <= 0 ){}
                    collection.put(5, count_5 - 1);
                    collection.put(10, count_10 - 1);
                    break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean ans = lemonadeChange(new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5});
        System.out.println(ans);
    }
}
