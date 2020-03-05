public class AliTest {
    public static Integer max(int[] level, int[] commission, int[] worker) {
        int max_benefit = 0;
        for (int w : worker) {
            max_benefit += avrMax(w, level, commission);
        }
        return max_benefit;
    }

    public static Integer avrMax(int w, int[] level, int[] commission) {
        int max_benefit = 0;
        for (int i = 0; i < level.length; i++) {
            if (w >= level[i]) {
                max_benefit = Math.max(max_benefit, commission[i]);
            }
        }
        return max_benefit;
    }

    public static void main(String[] args) {

    }
}
