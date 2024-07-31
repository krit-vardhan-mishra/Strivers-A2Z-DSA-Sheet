public class RecInsertionSort {
    public static void insertionSort(int[] arr, int col, int row) {
        if(col == row) return;

        int j = col;

        while (j > 0 && arr[j-1] > arr[j]) {
            int temp = arr[j-1];
            arr[j-1] = arr[j];
            arr[j] = temp;
            j--;
        }

        insertionSort(arr, col+1, row);
    }
}
