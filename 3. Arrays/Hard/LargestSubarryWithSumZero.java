import java.util.HashMap;

public class LargestSubarryWithSumZero {
    public static int maxLen(int[] arr, int N) {
        int K = 0;
        int sumElement = 0, maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            sumElement += arr[i];

            if (sumElement == K) {
                maxLength = Math.max(maxLength, i + 1);
            }

            if (map.containsKey(sumElement - K)) {
                maxLength = Math.max(maxLength, i - map.get(sumElement - K));
            }
            if (!map.containsKey(sumElement)) {
                map.put(sumElement, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] arr = { 1, 0, -4, 3, 1, 0 };
        System.out.println(maxLen(arr, arr.length));
    }
}
