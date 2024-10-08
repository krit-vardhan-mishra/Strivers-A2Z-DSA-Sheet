public class PeakElement {
    public static int findPeakElement(int[] nums) {
        int start = 0, end = nums.length-1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] < nums[mid+1]) start = mid + 1;
            else end = mid;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(findPeakElement(arr));
    }
}
