
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {

    // Failed in some test cases
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int sum = 0;
    //     sum += triangle.get(0).get(0);

    //     for (int i=1; i<triangle.size(); i++) {
    //         int[] temp = {Integer.MAX_VALUE, 0};
    //         for (int j=temp[1]; j<i+1; j++) {
    //             if (triangle.get(i).get(j) < temp[0]) {
    //                 temp[0] = triangle.get(i).get(j);
    //                 temp[1] = j;
    //             }
    //         }
    //         sum += temp[0];
    //     }

    //     return sum;
    // }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = triangle.get(n - 1).get(i);
        }
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }
    
}

public class Triangle {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(sol.minimumTotal(triangle));
    }    
}
