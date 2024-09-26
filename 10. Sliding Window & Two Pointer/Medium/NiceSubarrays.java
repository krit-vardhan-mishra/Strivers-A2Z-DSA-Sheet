
public class NiceSubarrays {
    public static int numberOfSubarrays(int[] nums, int k) {
        int result = 0, oddCount = 0;
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 1;
    
        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }
            if (oddCount >= k) {
                result += prefix[oddCount - k];
            }
            prefix[oddCount]++;
        }
    
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        System.out.println(numberOfSubarrays(nums, 2));
    }
}