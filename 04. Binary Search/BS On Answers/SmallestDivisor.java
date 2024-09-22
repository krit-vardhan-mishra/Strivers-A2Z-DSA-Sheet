
public class SmallestDivisor {

    public static int smallestDivisor(int[] nums, int threshold) {
        if(nums.length > threshold) return -1;

        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        int start = 1, end = maxi;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(func(nums, mid) <= threshold) end = mid - 1;
            else start = mid + 1;
        }

        return start;
    }

    private static int func(int[] arr, int mid) {
        int sum = 0;

        for (int i : arr) {
            sum += (int)Math.ceil((double)(i)/(double)(mid));
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        System.out.println(smallestDivisor(nums, 6));
    }
    
}