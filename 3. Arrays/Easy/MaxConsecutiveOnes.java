public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0;
        int currConsecutive = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                currConsecutive++;
                maxConsecutive = Math.max(maxConsecutive, currConsecutive);
            } else {
                currConsecutive = 0;
            }
        }

        return maxConsecutive;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}
