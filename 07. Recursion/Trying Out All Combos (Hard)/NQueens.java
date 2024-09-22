import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '_';
            }
        }

        List<List<String>> ans = new ArrayList<>();
        func(0, board, ans);

        return ans;
    }

    private static void func(int col, char[][] board, List<List<String>> ans) {
        if (col == board.length) {
            ans.add(construct(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if(isSafeQueen(board, i, col)) {
                board[i][col] = 'Q';
                func(col+1, board, ans);
                board[i][col] = '_';
            }
        }
    }

    public static List<String> construct(char[][] board) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            ans.add(s);
        }

        return ans;
    }

    public static boolean isSafeQueen(char[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q')
                return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
    
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
    
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = solveNQueens(4);
        for (List<String> list : res) {
            System.out.println(list);
        }
    }
}
