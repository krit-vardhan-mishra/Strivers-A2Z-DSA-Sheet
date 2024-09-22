import java.util.Arrays;

public class RowWithMax1 {

    public static int rowWithMax1s(int[][] arr) {
        int row = 0, col = arr[0].length-1, ans = -1;

        while (row < arr.length && col >= 0) {
            if(arr[row][col] == 1) {
                ans = row;
                col--;
            } else {
                row++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {0,1,1,1},
            {0,0,1,1},
            {1,1,1,1},
            {0,0,0,0}
        };

        for (int[] is : matrix) {
            System.out.println(Arrays.toString(is));
        }

        System.out.println(rowWithMax1s(matrix));
    }
}
