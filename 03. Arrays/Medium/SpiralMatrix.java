import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int top = 0, bottom = n-1, left = 0, right = m-1;
        
        while(top<=bottom && right >= left) {
            for(int i=left;i<=right;i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if(!(top<=bottom && right >= left)) {
                break;
            }
            for(int i=right;i>=left;i--) {
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            for(int i=bottom;i>=top;i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        for (int[] is : arr) {
            for (int is2 : is) {
                System.out.print(is2+" ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println(spiralOrder(arr));
    }
}
