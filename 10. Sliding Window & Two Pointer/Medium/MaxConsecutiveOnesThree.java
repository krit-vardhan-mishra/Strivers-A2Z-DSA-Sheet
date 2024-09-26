public class MaxConsecutiveOnesThree {
    public static int longestOne(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int max = 0;

        while (j < nums.length) {
            if (nums[j] == 0) {
                k--;
            }
            j++;
            while (k < 0) {
                if (nums[i] == 0) {
                    k++;
                }
                i++;
            }
            max = Math.max(max, j-i);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOne(nums, 2));
    }
}
