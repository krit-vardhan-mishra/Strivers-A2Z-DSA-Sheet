import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinatinSumTwo {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(0, target, res, new ArrayList<>(), candidates);

        return res;
    }

    private static void backtracking(int index, int target, List<List<Integer>> res, List<Integer> sol, int[] nums) {
        if(target == 0) {
            res.add(new ArrayList<>(sol));
            return;
        }
        
        for(int i=index; i<nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) continue;
            if(nums[i] > target) break;

            sol.add(nums[i]);
            backtracking(i + 1, target - nums[i], res, sol, nums);
            sol.remove(sol.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(candidates, 8));
    }
}
