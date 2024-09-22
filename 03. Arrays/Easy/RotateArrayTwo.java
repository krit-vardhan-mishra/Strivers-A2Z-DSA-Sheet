import java.util.Arrays;

public class RotateArrayTwo {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(nums1));
        rotate(nums1, 3);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {-1, -100, 3, 99};
        System.out.println(Arrays.toString(nums2));
        rotate(nums2, 2);
        System.out.println(Arrays.toString(nums2));
    }
}
