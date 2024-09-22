public class CountOccurance {

    public static int count(int[] arr, int n, int target) {
        return searchRange(arr, target);
    }

    public static int searchRange(int[] nums, int target) {
        int first = firstOcc(nums, target);
        if(first == -1) return -1;
        int last = lastOcc(nums, target);

        return last - first + 1;
    }

    public static int firstOcc(int[] arr, int target) {
        int ans = -1, start = 0, end = arr.length-1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] == target) {
                ans = mid;
                end = mid - 1;
            }
            else if(arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return ans;
    }

    public static int lastOcc(int[] arr, int target) {
        int ans = -1, start = 0, end = arr.length-1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] == target) {
                ans = mid;
                start = mid + 1;
            }
            else if(arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,3,4,4};
        System.out.println(count(arr, arr.length, 3));
    }
}
