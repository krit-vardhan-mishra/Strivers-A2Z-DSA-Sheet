public class SortedArraySearch {
    public static int searchInSorted(int[] arr, int n, int k) {
        int start = 0, end = n-1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == k) return 1;
            else if (arr[mid] > k) end = mid - 1;
            else start = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(searchInSorted(arr, arr.length, 6));    
    }
}
