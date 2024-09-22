import java.util.ArrayList;

public class RatInAMaze {

    public static ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> ans = new ArrayList<>();
        if(mat.length == 0 || mat[0].length == 0 || mat[0][0] == 0) {
            return ans;
        }
        
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        func(mat, 0, 0, "", ans, visited);

        return ans;
    }

    public static void func(int[][] mat, int row, int col, String str, ArrayList<String> ans, boolean[][] visited) {
        if(row < 0 || row >= mat.length || col < 0 || col >= mat[0].length || mat[row][col] == 0 || visited[row][col]) {
            return;
        }

        if(row == mat.length - 1 && col == mat[0].length - 1) {
            ans.add(str);
            return;
        }

        visited[row][col] = true;
        func(mat, row, col+1, str + 'R', ans, visited);
        func(mat, row+1, col, str + 'D', ans, visited);
        func(mat, row, col-1, str + 'L', ans, visited);
        func(mat, row-1, col, str + 'U', ans, visited);
        visited[row][col] = false;
    }

    public static void main(String[] args) {
        int[][] mat = {
            { 1, 0 }, 
            { 1, 0 }, 
        };
        System.out.println(findPath(mat));
    }
}
