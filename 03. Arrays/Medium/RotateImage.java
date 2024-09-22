import java.util.Arrays;

public class RotateImage {

    public static void rotate(int[][] mat) {
        
        // Transpose of Matrix
        for(int i=0;i<mat.length;i++) {
            for(int j=i+1;j<mat.length;j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        
        // Reverse of Matrix
        for(int i=0;i<mat.length;i++) {
            int left = 0;
            int right = mat[0].length-1;
            
            while(left<right) {
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrixrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        for (int[] is : matrixrix) {
            System.out.println(Arrays.toString(is));
        }

        rotate(matrixrix);

        for (int[] is : matrixrix) {
            System.out.println(Arrays.toString(is));
        }
    }
}
