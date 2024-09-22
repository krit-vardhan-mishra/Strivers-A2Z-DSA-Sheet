
public class CountNGEs {
    // 2.7
    public static int[] count_NGEs(int N, int[] arr, int queries, int[] indices) {
        int[] result = new int[queries];
    
        for (int i = 0; i < queries; i++) {
            int count = 0;
            int index = indices[i];
    
            for (int j = index + 1; j < N; j++) {
                if (arr[j] > arr[index]) {
                    count++;
                }
            }
            result[i] = count;
        }
    
        return result;
    }
    

    public static void main(String[] args) {
        int[] arr = {3,4,2,7,5,8,10,6};
        int[] indices = {0,5};
        int[] res = count_NGEs(arr.length, arr,2, indices);

        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}
