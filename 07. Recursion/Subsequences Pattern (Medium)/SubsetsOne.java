import java.util.ArrayList;
import java.util.List;

public class SubsetsOne {

    public static List<List<Integer>> subsets(int[] nums) {
        return sets(nums, new ArrayList<Integer>() ,0);
    }

    public static List<List<Integer>> sets(int[] nums, List<Integer> dig, int idx) {
        if(idx == nums.length) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>(dig));
            return ans;
        }

        int val = nums[idx];
        dig.add(val);
        List<List<Integer>> a1 = sets(nums, dig, idx+1); 
        dig.remove(dig.indexOf(val));
        a1.addAll(sets(nums, dig, idx+1));

        return a1;
    }

    /* 
    Optimized Code with same time complexity but reduced space complexity to O(n) by using loops.
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // Add empty set

        for (int num : nums) {
            int n = result.size();
            for (int i = 0; i < n; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(num);
                result.add(subset);
            }
        }
        return result;
    }
    */

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> ans = subsets(nums);
        System.out.println(ans);
    }
    
}