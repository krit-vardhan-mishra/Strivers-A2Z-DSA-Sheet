
public class SplitArrayLargestSum {
    public static int splitArray(int[] nums, int k) {
        int start = 0, end = 0;
        for (int num : nums) {
            start = Math.max(start, num);
            end += num;
        }

        while (start < end) {
            int mid = start + (end - start) / 2;

            if(isSplit(nums, mid) > k) start = mid + 1;
            else end = mid;
        }

        return start;
    }

    private static int isSplit(int[] nums, int mid) {
        int split = 1, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(sum > mid) {
                split++;
                sum = nums[i];
            }
        }

        return split;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(splitArray(nums, 2));
    }
}
