import java.util.Arrays;

class Solution {
    public int solve(int n, int m, int[][] grid) {
        int[][][] dp = new int[n][m][m];
    
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
    
        return helper(0, 0, m-1, grid, dp);
    }
    
    private int helper(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        if (j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length) {
            return Integer.MIN_VALUE;
        }
    
        if (i == grid.length - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }
    
        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }
    
        int maxChocolates = Integer.MIN_VALUE;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value;
                if (j1 == j2) {
                    value = grid[i][j1];
                } else {
                    value = grid[i][j1] + grid[i][j2];
                }
                value += helper(i + 1, j1 + dj1, j2 + dj2, grid, dp);
                maxChocolates = Math.max(maxChocolates, value);
            }
        }
    
        return dp[i][j1][j2] = maxChocolates;
    }
    
}

public class ChocolatesPickup {
    public static void main(String[] args) {
        int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        Solution sol = new Solution();
        System.out.println(sol.solve(grid.length, grid[0].length, grid));
    }
}

// [3,1,1]
// [2,5,1]
// [1,5,5]
// [2,1,1]