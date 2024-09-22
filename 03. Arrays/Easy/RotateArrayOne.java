public class RotateArrayOne {
    public static void solve(int[] nums) {
        int temp = nums[0];

        for (int i = 0; i < nums.length-1; i++) {
            nums[i] = nums[i+1];
        }
        
        nums[nums.length - 1] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        solve(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
