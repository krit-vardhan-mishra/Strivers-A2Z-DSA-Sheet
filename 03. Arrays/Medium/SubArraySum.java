import java.util.HashMap;

public class SubArraySum {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0;

        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int del = sum - k;
            count += map.getOrDefault(del, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1};
        System.err.println(subarraySum(arr, 2));
    }
}
