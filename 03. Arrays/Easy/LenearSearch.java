public class LenearSearch {
    public static int search(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == k) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,65,12,1,24,2};
        System.out.println(search(nums, 5));
    }
}
