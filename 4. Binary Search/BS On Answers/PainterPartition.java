public class PainterPartition {
    public static int findLargestMinDistance(int[] boards, int k) {
        int start = 0, end = 0;

        for (int board : boards) {
            start = Math.max(start, board);
            end += board;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(distance(boards, mid) > k) start = mid + 1;
            else end = mid - 1;
        }

        return start;
    }

    public static int distance(int[] arr, int mid) {
        int count = 1, sum = 0;

        for (int i : arr) {
            sum += i;

            if(sum > mid) {
                count++;
                sum = i;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        System.out.println(findLargestMinDistance(arr, 2));
    }
}
