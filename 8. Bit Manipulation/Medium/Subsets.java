import java.util.List;
import java.util.ArrayList;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i=0; i<(1 << n); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j=0; j<n; j++) {
                if (((1<<j) & i) > 0) {
                    temp.add(nums[j]);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
