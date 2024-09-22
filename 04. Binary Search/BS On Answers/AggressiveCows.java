import java.util.Arrays;

public class AggressiveCows {
    public static int aggressiveCows(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int start = 1, end = arr[n-1]-arr[0];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(place(arr, mid, k)) start = mid + 1;
            else end = mid - 1;
        }

        return end;
    }

    private static boolean place(int[] arr, int mid, int k) {
        int count = 1, last = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] - last >= mid) {
                count++;
                last = arr[i];
            }

            if(count >= k) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0,3,4,7,10,9};
        System.out.println(aggressiveCows(arr,4));
    }
}
