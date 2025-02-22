
class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;

        boolean[][] dp = new boolean[n+1][sum+1];

        for (int i=0; i<=n; i++) {
            dp[i][0] = true;
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=sum; j++) {
                if (j < arr[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }

        return dp[n][sum];
    }
}

public class SubsetSumProblem {
    public static void main(String[] args) {
        int[] arr = {3,34,4,12,5,2};
        int sum = 9;
        System.out.println(Solution.isSubsetSum(arr, sum));
    }
}
