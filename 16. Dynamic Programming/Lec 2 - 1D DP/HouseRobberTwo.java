
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        if (n == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));
    
        return Math.max(robHelper(nums, 0, n - 2), robHelper(nums, 1, n - 1));
    }
    
    private int robHelper(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
    
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
    
        return dp[end];
    }
    
}

public class HouseRobberTwo {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2,3,2};
        int res = sol.rob(nums);
        System.out.println(res);
    }
}
