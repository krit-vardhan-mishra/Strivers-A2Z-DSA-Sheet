public class MedianOfMatrix {

    public static int median(int[][] matrix, int R, int C) {
        int row = Integer.MAX_VALUE, col = Integer.MIN_VALUE;
        int req = (R * C) / 2;

        for (int i = 0; i < R; i++) {
            row = Math.min(row, matrix[i][0]);
            col = Math.max(col, matrix[i][C-1]);
        }

        while (row <= col) {
            int mid = (row + col) / 2;
            int small = func(matrix, mid);

            if(small <= req) row = mid + 1;
            else col = mid - 1;
        }

        return row;
    }

    private static int func(int[][] mat, int val) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            count += upperBond(mat[i], val, mat[i].length);
        }
        return count;
    }

    private static int upperBond(int[] mat, int val, int m) {
        int low = 0, high = m - 1;
        int ans = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mat[mid] > val) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,4,9},
            {2,5,6},
            {3,8,7}
        };

        System.out.println(median(matrix, matrix.length, matrix[0].length));
    }
}
