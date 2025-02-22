
class Solution {
    public int maximumPoints(int arr[][], int N) {
        // code here
        int[][] dp = new int[N][3];

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = arr[i][0] + Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = arr[i][1] + Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Math.max(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.max(dp[N - 1][0], Math.max(dp[N - 1][1], dp[N - 1][2]));
    }
}

public class GeekTraining {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] arr = { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } };
        int N = 3;
        int res = sol.maximumPoints(arr, N);
        System.out.println(res);
    }
}
