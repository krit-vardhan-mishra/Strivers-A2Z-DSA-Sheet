

public class SubarraysWithKDistinct {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }

    public int helper(int[] nums, int k) {
        int ans = 0;
        int[] count = new int[nums.length+1];

        for (int i = 0, j = 0; i < nums.length; i++) {
            if (++count[nums[i]] == 1) --k;
            while (k == -1) {
                if (--count[nums[j++]] == 0) ++k;
            }
            ans += i - j + 1;
        }
        return ans;
    }
}
