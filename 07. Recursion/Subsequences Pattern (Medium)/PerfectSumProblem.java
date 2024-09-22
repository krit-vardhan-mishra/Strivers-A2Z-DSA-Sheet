import java.util.Arrays;

public class PerfectSumProblem {
    static final int MOD = 1000000007;
 
    public static int numberOfWays(int i, int sum, int[] arr, int n, int[][] dp) {
        if (sum == 0 && i == n) return 1;

        if (i >= n || sum < 0) return 0;
 
        if (dp[i][sum] != -1) return dp[i][sum];
 
        int pick = numberOfWays(i + 1, sum - arr[i], arr, n, dp);
        int notPick = numberOfWays(i + 1, sum, arr, n, dp);
        return dp[i][sum] = (pick+ notPick) % MOD;
    }
 
    public static int perfectSum(int[] arr, int n, int sum) {
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        if (totalSum < sum) return 0;
 
        int[][] dp = new int[n + 1][totalSum + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
 
        int ans = numberOfWays(0, sum, arr, n, dp);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,5,1,4,3};
        System.out.println(perfectSum(arr, arr.length, 10));
    }
}
