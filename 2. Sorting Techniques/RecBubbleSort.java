public class RecBubbleSort {
    public static void bubbleSort(int[] arr, int row, int col) {
        if(row == 0) return;

        if(col < row) {
            if(arr[col] < arr[col+1]) {
                int temp = arr[col];
                arr[col] = arr[col+1];
                arr[col+1] = temp;
            }
            bubbleSort(arr, row, col+1);
        } else {
            bubbleSort(arr, row-1, col);
        }
    }
}
