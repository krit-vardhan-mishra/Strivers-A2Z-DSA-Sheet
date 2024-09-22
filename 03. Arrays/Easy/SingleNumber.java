public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int XOR = 0;

        for (int i : nums) {
            XOR ^= i;
        }

        return XOR;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,2,1};
        int[] nums2 = {4,1,2,1,2};
        int[] nums3 = {1};
        System.out.println(singleNumber(nums1));
        System.out.println(singleNumber(nums2));
        System.out.println(singleNumber(nums3));
    }
}
