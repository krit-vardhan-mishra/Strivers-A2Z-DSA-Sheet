import java.util.ArrayList;

public class MergeKSortedArray {
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) 
    {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<>();

        for (int[] a1 : arr) {
            for (int a2 : a1) {
                result.add(a2);
            }
        }

        int n = result.size();

        for (int i = (n-2)/2; i >= 0; i--) {
            heapify(result, n, i);
        }

        for (int i = n-1; i >= 0; i--) {
            int temp = result.get(0);
            result.set(0, result.get(i));
            result.set(i, temp);
            heapify(result, i, 0);
        }

        return result;
    }

    public static void heapify(ArrayList<Integer> nums, int n, int i) 
    {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < n && nums.get(largest) < nums.get(left)) largest = left;
        if (right < n && nums.get(largest) < nums.get(right)) largest = right;

        if (largest != i) {
            int temp = nums.get(i);
            nums.set(i, nums.get(largest));
            nums.set(largest, temp);
            heapify(nums, n, largest);
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{1,2,3,4},{2,2,3,4},{5,5,6,6},{7,8,9,9}};
        System.out.println(mergeKArrays(arr, arr[0].length));
    }
}
