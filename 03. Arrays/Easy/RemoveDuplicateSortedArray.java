import java.util.Arrays;

public class RemoveDuplicateSortedArray {

    public static int removeDuplicate(int[] nums) {
        int count = 1;
        int j = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        System.out.println(Arrays.toString(arr));
        System.out.println(removeDuplicate(arr));
        System.out.println(Arrays.toString(arr));
    }
    
}