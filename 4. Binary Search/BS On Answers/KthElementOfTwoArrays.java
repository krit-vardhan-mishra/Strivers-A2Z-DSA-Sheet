
public class KthElementOfTwoArrays {

    public static long kthElement(int k, int[] arr1, int[] arr2) {
        int len1 = arr1.length, len2 = arr2.length;

        if(len1 > len2) return kthElement(k, arr2, arr1);

        int start = Math.max(0, k-len2), end = Math.min(k, len1);

        while (start <= end) {
            int mid = (start + end) / 2;

            int mid1 = mid;
            int mid2 = k - mid;

            int left1 = (mid1 == 0) ? Integer.MIN_VALUE : arr1[mid1 - 1];
            int left2 = (mid2 == 0) ? Integer.MIN_VALUE : arr2[mid2 - 1];
            int right1 = (mid1 == len1) ? Integer.MAX_VALUE : arr1[mid1];
            int right2 = (mid2 == len2) ? Integer.MAX_VALUE : arr2[mid2];

            if((left1 <= right2) && (left2 <= right1)) {
                return Math.max(left1,left2);
            } else if (left1 > right2) end = mid1 - 1;
            else start = mid1 + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,6,7,9};
        int[] arr2 = {1,4,8,10};
        System.out.println(kthElement(5, arr1, arr2));
    }
    
}