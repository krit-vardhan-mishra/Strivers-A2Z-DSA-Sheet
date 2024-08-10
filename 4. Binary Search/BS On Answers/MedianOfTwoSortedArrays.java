public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;

        if(len1 > len2) return findMedianSortedArrays(nums2, nums1);

        int start = 0, end = len1;

        while (start <= end) {
            int mid1 = (start + end) >> 1;
            int mid2 = ((len1 + len2 + 1) / 2) - mid1;

            int left1 = mid1-1 >= 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int left2 = mid2-1 >= 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int right1 = mid1 < len1 ? nums1[mid1] : Integer.MAX_VALUE;
            int right2 = mid2 < len2 ? nums2[mid2] : Integer.MAX_VALUE;

            if((left1 <= right2) && (left2 <= right1)) {
                if((len1 + len2) % 2 == 0) {
                    return ((double)(Math.max(left2, left1) + Math.min(right2, right1))) / 2.0;
                } else {
                    return (double)Math.max(left1, left2);
                }
            } else if(left1 > right2) {
                end = mid1 - 1;
            } else {
                start = mid1 + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
