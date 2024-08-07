
public class FindKthRotation {

    public static int findKRoatation(int[] arr) {
        int start = 0, end = arr.length-1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] < arr[end]) end = mid;
            else start = mid + 1;
        }

        return start;
    }

    public static void main(String[] args) {
        int[] arr = {5,1,2,3,4};
        System.out.println(findKRoatation(arr));
    }
    
}