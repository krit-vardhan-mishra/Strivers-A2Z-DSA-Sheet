import java.util.HashMap;

public class ReplaceWithRank {
    static int[] replaceWithRank(int[] arr, int N) {
        // code here
        int[] psudoarr = arr.clone();
        int n = psudoarr.length;
        for (int i = (n-2)/2; i >= 0; i--) {
            heapify(psudoarr, n, i);
        }
        
        for (int i = n-1; i >= 0; i--) {
            int temp = psudoarr[0];
            psudoarr[0] = psudoarr[i];
            psudoarr[i] = temp;
            heapify(psudoarr, i, 0);
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int i : psudoarr) {
            if (!map.containsKey(i)) {
                map.put(i, rank++);
            }
        }
        
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = map.get(arr[i]);
        }
        
        return result;

    }

    static void heapify(int[] nums, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && nums[largest] < nums[l]) largest = l;
        if (r < n && nums[largest] < nums[r]) largest = r;

        if (largest!= i) {
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;
            heapify(nums, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 6};
        int[] result = replaceWithRank(arr, arr.length);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
