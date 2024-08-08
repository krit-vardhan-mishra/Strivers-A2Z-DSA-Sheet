public class FirstAndLastOccurance {

    public static int[] searchRange(int[] nums, int target) {
        int first = firstOcc(nums, target);
        if(first == -1) return new int[]{-1,-1};
        int last = lastOcc(nums, target);

        return new int[]{first, last};
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
        int[] arr = {1,1,2,2,2,2,3};
        int[] res = searchRange(arr, 2);
        System.err.println(res[0]+" "+res[1]);
    }
}
