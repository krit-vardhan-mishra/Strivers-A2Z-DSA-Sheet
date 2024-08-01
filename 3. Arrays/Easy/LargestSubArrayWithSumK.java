import java.util.HashMap;

public class LargestSubArrayWithSumK {
    public static int lenOfLongSubarr(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if(sum == k) {
                maxLen = i+1;
            } else if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {10,5,2,7,1,9};
        System.out.println(lenOfLongSubarr(arr, arr.length, 15));
    }
}
