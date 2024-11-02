
class Solution {
    public int minimumEnergy(int arr[], int N) {
        // code here
        if (N == 1) return 0;
        int[] dp = new int[N];
        dp[0] = 0;
        dp[1] = Math.abs(arr[1] - arr[0]);

        for (int i = 2; i < N; i++) {
            dp[i] = Math.min(dp[i - 1] + Math.abs(arr[i] - arr[i - 1]), dp[i - 2] + Math.abs(arr[i] - arr[i - 2]));
        }

        return dp[N - 1];
    }
}

public class GeekJump {
    public static void main(String[] args) {
        int N = 4;
        int[] arr = { 10, 20, 30, 10 };
        Solution sol = new Solution();
        int res = sol.minimumEnergy(arr, N);
        System.out.println(res);
    }
}
