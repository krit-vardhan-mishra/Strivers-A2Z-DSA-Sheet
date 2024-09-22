import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsTwo {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // Must need to sort the array first
        funcVoid(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void funcVoid(int[] nums, int index, List<Integer> sol, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(sol));
            return;
        }

        sol.add(nums[index]);
        funcVoid(nums, index + 1, sol, ans);
        sol.remove(sol.size() - 1);

        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        funcVoid(nums, index + 1, sol, ans);
    }

    public static void main(String[] args) {
        int[] nums = { 4, 4, 4, 1, 4 };
        System.out.println(subsetsWithDup(nums));
    }
}
