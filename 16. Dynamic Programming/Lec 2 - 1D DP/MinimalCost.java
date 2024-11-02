
class Solution {
    public int minimizeCost(int k, int arr[]) {
        // code here
        if (arr.length == 1) return 0;
    int[] dp = new int[arr.length];
    dp[0] = 0;

    for (int i = 1; i < arr.length; i++) {
        dp[i] = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (i - j >= 0) {
                dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(arr[i] - arr[i - j]));
            }
        }
    }

    return dp[arr.length - 1];
    }
}

public class MinimalCost {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 10 };
        Solution sol = new Solution();
        int res = sol.minimizeCost(1, arr);
        System.out.println(res);
    }
}
