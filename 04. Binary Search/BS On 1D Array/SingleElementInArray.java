public class SingleElementInArray {

    public static int singleNonDuplicate(int[] nums) {
        if(nums.length == 1 || nums[0] != nums[1]) return nums[00];
        else if(nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];

        int start = 1, end = nums.length-2;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid];
            else if((mid % 2 != 0 && nums[mid-1] == nums[mid]) || (mid % 2 == 0 && nums[mid] == nums[mid+1])) start = mid + 1;
            else end = end - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4,5,5,6,6,7,8,8,};
        System.out.println(singleNonDuplicate(arr));
    }
}
