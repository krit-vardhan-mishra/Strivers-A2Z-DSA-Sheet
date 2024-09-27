
public class ConvertMinToMaxHeap {
    static void convertMinToMaxHeap(int N, int arr[]) 
    {
        // code here
        for (int i = (N - 2) / 2; i >= 0; i--) {
            heapify(N, arr, i);
        }
    }

    static void heapify(int N, int arr[], int i) 
    {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < N && arr[left] > arr[largest]) largest = left;
        if (right < N && arr[right] > arr[largest]) largest = right;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(N, arr, largest);
        }
    }
}
