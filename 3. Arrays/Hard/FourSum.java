import java.util.*;

public class FourSum {
    
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        
        if(n < 4) {
            return new ArrayList<>();
        }
        
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<n-3;i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;

            for(int j=i+1;j<n-2;j++) {
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                
                int k = j+1, r = n-1;
                while(k<r) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[r];
                    if(sum == target) {
                        ans.add(Arrays.asList(nums[i],nums[j],nums[k],nums[r]));
                        while(k<r && nums[k] == nums[k+1]) k++;
                        while(k<r && nums[r] == nums[r-1]) r--;
                        k++; r--;
                    }
                    else if(sum > target) r--;
                    else k++;
                }
            }
        }
        return ans;
    }

	public static void main(String[] args) {
		System.out.println("Hello World");
		int[] arr = {1000000000,1000000000,1000000000,1000000000};
		List<List<Integer>> ans = fourSum(arr, -294967296);
		System.out.println(ans);
		
	}
}