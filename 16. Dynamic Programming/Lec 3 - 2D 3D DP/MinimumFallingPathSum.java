
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        System.arraycopy(matrix[0], 0, dp[0], 0, n);

        for (int i=1; i<n; i++) {
            for (int j=0; j<n; j++) {
                int min = dp[i-1][j];
                if (j > 0) {
                    min = Math.min(min, dp[i-1][j-1]);
                }
                if (j < n-1) {
                    min = Math.min(min, dp[i-1][j+1]);
                }
                dp[i][j] = matrix[i][j] + min;
            }
        }

        int minPathSum = Integer.MAX_VALUE;

        for (int i=0; i<n; i++) {
            minPathSum = Math.min(minPathSum, dp[n-1][i]);
        }

        return minPathSum;
    }
}

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(sol.minFallingPathSum(matrix));
    }
}
