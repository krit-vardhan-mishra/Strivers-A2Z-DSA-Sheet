public class LargestElement {
    public static int largest(int n, int[] arr) {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            if(arr[i] > max) max = arr[i];
        }

        return max;
    }
    public static void main(String[] args) {
        int[] arr = {1,8,7,56,90};
        System.out.println(largest(arr.length, arr));
    }
}
