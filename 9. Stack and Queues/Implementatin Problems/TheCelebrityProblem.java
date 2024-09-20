import java.util.Stack;

public class TheCelebrityProblem {

    public static int celebrity(int[][] mat) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < mat.length; i++) {
            stack.push(i);
        }
        
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            
            if (mat[a][b] == 1) stack.push(b);
            else stack.push(a);
        }
        
        int count = stack.pop();
        for (int i = 0; i < mat.length; i++) {
            if (i != count && (mat[count][i] == 1 || mat[i][count] == 0)) return -1;
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] mat1 = {
            {0,1,0},
            {0,0,0},
            {0,1,0}
        };
        System.out.println(celebrity(mat1));

        int[][] mat2 = {
            {0,1},
            {1,0}
        };
        System.out.println(celebrity(mat2));
    }
}
