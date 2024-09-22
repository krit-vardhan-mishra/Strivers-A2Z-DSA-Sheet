public class SearchInRotatedArrayTwo {
    public static boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return true;
            else if(nums[mid] == nums[start] && nums[mid] == nums[end]) {
                end--;
                start++;
                continue;
            } else if(nums[start] <= nums[mid]) {
                if(nums[start] <= target && nums[mid] >= target) end = mid - 1;
                else start = mid + 1;
            } else {
                if(nums[mid] <= target && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 1, 1, 1 };
        System.out.println(search(arr, 0));
    }
}
