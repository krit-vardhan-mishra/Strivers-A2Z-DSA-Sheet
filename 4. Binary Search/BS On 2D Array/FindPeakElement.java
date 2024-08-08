import java.util.Arrays;

public class FindPeakElement {

    public static int[] findPeakGrid(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int row = 0, col = cols - 1; 

        while (row <= col) {
            int mid = (row + col) / 2;
            int rowIdx = maxElement(mat, rows, mid);

            int left = mid - 1 >= 0 ? mat[rowIdx][mid-1] : -1;
            int right = mid + 1 < cols ? mat[rowIdx][mid+1] : -1;

            if(mat[rowIdx][mid] > left && mat[rowIdx][mid] > right) return new int[]{rowIdx, mid};
            else if(mat[rowIdx][mid] < left) col = mid - 1;
            else row = mid + 1;

        }

        return new int[]{-1,-1};
    }

    public static int maxElement(int[][] mat, int row, int mid) {
        int max = -1, idx = -1;

        for (int i = 0; i < row; i++) {
            if(mat[i][mid] > max) {
                max = mat[i][mid];
                idx = i; 
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {25,37,23,37,19},
            {45,19,2,43,26},
            {18,1,37,44,50}
        };
        System.out.println(Arrays.toString(findPeakGrid(matrix)));
    }
    
}