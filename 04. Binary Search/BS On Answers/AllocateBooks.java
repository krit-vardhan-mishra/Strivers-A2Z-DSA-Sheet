import java.util.Arrays;

public class AllocateBooks {
    public static long allocateBooks(int[] arr, int n, int m) {
        if(n < m) return -1;

        Arrays.sort(arr);
        int start = Integer.MIN_VALUE, end = 0;

        for (int i : arr) {
            start = Math.max(start, i);
            end += i;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(allocation(arr, mid) > m) start = mid + 1;
            else end = mid - 1;
        }

        return start;
    }

    private static int allocation(int[] arr , int mid) {
        int student = 1, sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum > mid) {
                student++;
                sum = arr[i];
            }
        }

        return student;
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        System.out.println(allocateBooks(arr, arr.length, 2));
    }
}
