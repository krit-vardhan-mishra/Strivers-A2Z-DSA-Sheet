
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
    
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
    
        for (int i = 1; i < row; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
        }
    
        for (int j = 1; j < col; j++) {
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
        }
    
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
    
        return dp[row - 1][col - 1];
    }
    
}

public class UniquePathsTwo {
    public static void main(String[] args) {
        int[][] arr = {{0,0,0}, {0,1,0},{0,0,0}};
        Solution sol = new Solution();
        int res = sol.uniquePathsWithObstacles(arr);
        System.out.println(res);
    }
}
