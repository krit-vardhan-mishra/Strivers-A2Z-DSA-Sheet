import java.util.Arrays;

public class FreqOfMostFreqElem {
    public static int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);

        int ans = 0;
        long sum = 0;

        for(int i = 0, r = 0; r < arr.length; r++) {
            sum += arr[r];
            while(sum + k < (long) arr[r] * (r-i+1)) {
                sum -= arr[i++];
            }
            ans = Math.max(ans, r-i+1);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,2, 4};
        System.out.println(maxFrequency(arr, 5));
    }
}
