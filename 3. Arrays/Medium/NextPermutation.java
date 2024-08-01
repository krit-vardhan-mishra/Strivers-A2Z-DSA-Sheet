import java.util.Arrays;

public class NextPermutation {

    public static void nextPermutation(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = arr.length - 1;
            while (arr[i] >= arr[j]) {
                j--;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        reverse(arr, i + 1, arr.length - 1);
    }

    public static void reverse(int[] arr, int s, int e) {
        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 1 };
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}