import java.util.ArrayList;
import java.util.List;

public class CombinationSumOne {

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();        
        backtracking(0, target, res, new ArrayList<>(), candidates);
        
        return res;
    }
    
    static void backtracking(int i, int target, List<List<Integer>> res, List<Integer> sol, int[] nums) {
        if(i == nums.length) {
            if(target == 0) {
                res.add(new ArrayList<>(sol));
            }
            return;
        }

        if(nums[i] <= target) {
            sol.add(nums[i]);
            backtracking(i, target - nums[i], res, sol, nums);
            sol.remove(sol.size()-1);
        }
                
        backtracking(i + 1, target, res, sol, nums);
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        System.out.println(combinationSum(candidates, 7));
    }
}
