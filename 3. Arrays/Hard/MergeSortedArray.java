public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;

        int i = m - 1, j = n - 1, k = n + m - 1;

        while (i >= 0 && j >= 0) {
            if(nums1[i] < nums2[j]) {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};

        merge(arr1, 3, arr2, 3);

        for (int i : arr1) {
            System.out.print(i+" ");
        }
    }
}
