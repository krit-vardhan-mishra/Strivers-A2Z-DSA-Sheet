public class FloorInSortedArray {
    public static int findFloor(long[] arr, int n, long x) {
        int start = 0, end = arr.length-1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] <= x) start = mid + 1;
            else end = mid - 1;
        }
        return end;
    }

    public static void main(String[] args) {
        long[] arr = {1,2,8,10,11,12,19};
        System.err.println(findFloor(arr, arr.length, 5));
    }

}
