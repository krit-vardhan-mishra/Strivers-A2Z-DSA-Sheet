import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (prefixSum.containsKey(sum - goal)) {
                count += prefixSum.get(sum - goal);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 0,0,0,0,0};
        System.out.println(numSubarraysWithSum(nums, 0));
    }
}
