import java.util.*;

public class SurroundedRegions {

    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        if (m <= 2 || n <= 2) return;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            if (board[0][i] == '0' && !visited[0][i]) dfs(board, 0, i, visited);
            if (board[m-1][i] == '0' && !visited[m-1][i]) dfs(board, m-1, i, visited);
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == '0' && !visited[i][0]) dfs(board, i, 0, visited);
            if (board[i][n-1] == '0' && !visited[i][n-1]) dfs(board, i, n-1, visited);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '0' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(char[][] board, int i, int j, boolean[][] visited) {
        int m = board.length, n = board[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] == 'X') {
            return;
        }
        
        visited[i][j] = true;

        dfs(board, i+1, j, visited);
        dfs(board, i-1, j, visited);
        dfs(board, i, j+1, visited);
        dfs(board, i, j-1, visited);
    }

    public static void main(String[] args) {
        char[][] board = {{'x','x','x','x'},{'x','0','0','x'},{'x','x','0','x'},{'x','0','x','x'}};
        for (int j = 0; j < board.length; j++) {
            System.out.println(Arrays.toString(board[j]));
        }

        System.out.println();
        solve(board);

        for (int j = 0; j < board.length; j++) {
            System.out.println(Arrays.toString(board[j]));
        }
    }
}
