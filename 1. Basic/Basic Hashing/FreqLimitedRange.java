public class FreqLimitedRange {

    public static void frequencyCount(int arr[], int N, int p) {
        int[] freq = new int[p]; 
        for (int i = 0; i < N; i++) { 
            if (arr[i] >= 1 && arr[i] <= p) { 
                freq[arr[i]-1]++; 
            } 
        } 
        for(int i=0;i<N;i++) {
            if(i<p) {
                arr[i] = freq[i];
            } else {
                arr[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,2,3,5};
        frequencyCount(arr, 5, 5);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
