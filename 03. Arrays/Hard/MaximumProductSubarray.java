
public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        int n = nums.length;

        if (n == 0)
            return 0;

        int prod1 = nums[0], prod2 = nums[0], product = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                int temp = prod1;
                prod1 = prod2;
                prod2 = temp;
            }

            prod1 = Math.max(nums[i], prod1 * nums[i]);
            prod2 = Math.min(nums[i], prod2 * nums[i]);

            product = Math.max(product, prod1);
        }
        return product;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 0, -1 };
        System.out.println(maxProduct(arr));
    }

}