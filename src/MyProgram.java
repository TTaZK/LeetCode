import java.util.ArrayList;
import java.util.List;

public class MyProgram {

    public static void main(String[] args) {
        List<AnyTrigFunction> list = new ArrayList<>();
        AnyTrigFunction sin3 = new SineFunction(1.0, 1.0);
        AnyTrigFunction sin1 = new SineFunction(1.5, 5.0);
        AnyTrigFunction sin2 = new SineFunction(2.0, 10.0);
        AnyTrigFunction cos3 = new CosineFunction(1.0, 1.0);
        AnyTrigFunction cos1 = new CosineFunction(1.5, 5.0);
        AnyTrigFunction cos2 = new CosineFunction(2.0, 10.0);
        list.add(sin3);
        list.add(sin1);
        list.add(sin2);
        list.add(cos3);
        list.add(cos1);
        list.add(cos2);
        bubbleSort(list);
        for (AnyTrigFunction a : list) {
            System.out.println(a.trigFunction(0.5));
        }
    }

    public static void bubbleSort(List<AnyTrigFunction> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j).trigFunction(0.5) > list.get(j + 1).trigFunction(0.5)) {
                    AnyTrigFunction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}
