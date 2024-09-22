public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if(low<high) {
            int partition = func(arr, low, high);
            quickSort(arr, low, partition-1);
            quickSort(arr, partition+1, high);
        }
        return;
    }
    
    public static int func(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;
        while(i<j) {
            while(arr[i] <= pivot && i <= high-1) {
                i++;
            }
            while(arr[j] > pivot && j >= low+1) {
                j--;
            }
            if(i<j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }
    
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
