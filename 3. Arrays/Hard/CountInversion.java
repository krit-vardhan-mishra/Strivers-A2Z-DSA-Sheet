import java.util.ArrayList;
import java.util.List;

public class CountInversion {
    public static int inversionCount(long[] nums, int n) {
        return mergeSort(nums, 0, nums.length-1);
    }
    
    public static int mergeSort(long[] nums, int start, int end) {
        int count = 0;
        if(start >= end) return count;
        int mid = start + (end - start)/2;
        count = mergeSort(nums, start, mid) + mergeSort(nums, mid+1, end);
        count += merge(nums, start, mid, end);
        
        return count;
    }
    
    public static int merge(long[] arr, int start, int mid, int end) {
        int j = mid+1, count = 0;
        
        for (int i = start; i <= mid; i++) {
            while (j <= end && arr[i] > arr[j]) j++;
            count += (j - (mid + 1));
        }
        
        List<Long> list = new ArrayList<>();
        int left = start, right = mid+1;
        while(left <= mid && right <= end) {
            if(arr[left] <= arr[right]) list.add(arr[left++]);
            else list.add(arr[right++]);
        }
        
        while (left <= mid) list.add(arr[left++]);
        while (right <= end) list.add(arr[right++]);
        
        for (int i = start; i <= end; i++) arr[i] = list.get(i - start);
        
        return count;
    }
    
    public static void main(String[] args) {
        long[] arr = {2,4,1,3,5};
        System.out.println(inversionCount(arr, arr.length));
    }
}
