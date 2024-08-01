import java.util.Arrays;

public class SortColor {
    public static void sortColor(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;

    while (j <= k) {
        if (nums[j] == 0) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j++;
        } else if (nums[j] == 1) {
            j++;
        } else {
            int temp = nums[j];
            nums[j] = nums[k];
            nums[k] = temp;
            k--;
        }
    }
    }

    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println(Arrays.toString(arr));
        sortColor(arr);
        System.out.println(Arrays.toString(arr));
    }
}
