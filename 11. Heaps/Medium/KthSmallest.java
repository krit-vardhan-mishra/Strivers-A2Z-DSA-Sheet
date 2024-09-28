
public class KthSmallest {
    public static int kthSmallest(int[] nums, int k) {
        // Your code here
        int n = nums.length;
        for (int i = (n-2)/2; i >= 0; i--) {
            heapify(nums, n, i);
        }

        for (int i = n-1; i >= n-k; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums, i, 0);
        }

        return nums[n-k];
    }

    public static void heapify(int[] nums, int n, int i) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < n && nums[largest] > nums[left]) largest = left;;
        if (right < n && nums[largest] > nums[right]) largest = right;

        if (largest != i) {
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;
            heapify(nums, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,20,15};
        System.out.println(kthSmallest(arr, 4));
    }
}
