
public class SelectionSort {
    public static void selectionSort(int[] arr, int n) {
        for(int i = 0; i < n-1; i++) {
            int small = i;
            for(int j = i+1; j< n;j++) {
                if(arr[small]  > arr[j]) {
                    small = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[small];
            arr[small] = temp;
        }
    }
}
