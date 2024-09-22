public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n+1];
        int missing = 0;

        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
        }
        
        for (int i = 0; i < hash.length; i++) {
            if(hash[i] == 0) {
                missing = i;
                break;
            } 
        }
        return missing;
    }

    public static void main(String[] args) {
        int[] arr = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(arr));
    }
}
