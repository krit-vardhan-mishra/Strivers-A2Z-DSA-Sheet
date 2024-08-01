// Kadane's Algorithm
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, sum = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = sum > maxSum ? sum : maxSum;
            if(sum < 0) sum = 0;
        }

        return maxSum;
    }    

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
