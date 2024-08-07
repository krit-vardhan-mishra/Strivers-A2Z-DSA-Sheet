public class CeilInSortedArray {
    public static int findCeil(int x, int[] arr) {
        int start = 0, end = arr.length-1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] <= x) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,8,9,15,19};
        System.out.println(findCeil(9, arr));
    }
}
