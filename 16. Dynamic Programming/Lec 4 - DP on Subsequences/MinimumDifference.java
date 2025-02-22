public class MinimumDifference {

    public static int minimumDifference(int[] nums) {
        int n = nums.length;
        int sum = 0, offset = 0;

        for (int num : nums) {
            sum += num;
            offset = Math.min(num, offset);
        }

        if (offset < 0) {
            offset = -offset;
            
            for (int i=0; i<n; i++) {
                nums[i]  += offset;
            }
        } else {
            offset = 0;
        }

        int target = sum / 2 + offset * n;
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= 0; j--) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int adj = sum + offset * n;
        return Math.abs(adj - 2 * dp[n][target]);
    }

    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[] { -36, 36 }));
    }
}
