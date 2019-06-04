import java.util.ArrayList;
import java.util.List;

public class No39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length <= 0)
            return result;
        for (int candidate : candidates) {
            if (target == candidate) {
                List<Integer> meta = new ArrayList<>();
                meta.add(target);
                result.add(meta);
            } else if (target > candidate) {
                List<Integer> meta = combinationSum(candidates, target, new ArrayList<>());
                result.add(meta);
            } else {
                continue;
            }
        }
        return result;
    }

    public static List<Integer> combinationSum(int[] candidates, int target, List<Integer> result) {
        for (int candidate : candidates) {
            if (candidate == target) {
                result.add(target);
                return result;
            } else if (target > candidate) {
                result.add(candidate);
                combinationSum(candidates, target - candidate, result);
            } else {
                continue;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
