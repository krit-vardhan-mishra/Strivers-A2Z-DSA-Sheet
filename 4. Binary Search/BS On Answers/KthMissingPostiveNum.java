public class KthMissingPostiveNum {
    public int findKthPositive(int[] arr, int k) {
        int missingCount = 0, current = 1, idx = 0;

        while (missingCount < k) {
            if(idx < arr.length && arr[idx] == current) idx++;
            else {
                missingCount++;
                if(missingCount == k) return current;
            }
            current++;
        }

        return -1;
    }
}
