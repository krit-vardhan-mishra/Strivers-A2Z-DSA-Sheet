import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        if(nums.length == 1) return;

        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12,0,343,0,0,0,123};
        System.out.println(Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
