public class SudokuSolver {

    public static void solveSudoku(char[][] board) {
        solveSudoku1(board);
    }
    
    private static boolean solveSudoku1(char[][] board) {
        int row = -1, col = -1;
        boolean isEmpty = true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == '.') {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if(!isEmpty) break;
        }

        if(isEmpty) return true;

        for(int num = 1; num <= 9; num++) {
            if(isSafe(board, row, col, num)) {
                board[row][col] = (char)(num+'0');
                if(solveSudoku1(board)) return true;
                board[row][col] = '.';
            }
        }

        return false;
    }

    private static boolean isSafe(char[][] board, int row, int col, int number) {
        for (int i = 0; i < board.length; i++) {
            if(board[row][i] == (char)(number + '0')) return false;
        }

        for(char[] ch : board) {
            if(ch[col] == (char)(number + '0')) return false;
        }

        int sqrt = (int)(Math.sqrt(board.length));
        int rStart = row - row % sqrt;
        int cStart = col - col % sqrt;

        for (int i = rStart; i < rStart + sqrt; i++) {
            for (int j = cStart; j < cStart + sqrt; j++) {
                if(board[i][j] == (char)(number + '0')) return false;
            }
        }

        return true;
    }

    public static void display(char[][] board) {
        for (char[] is : board) {
            for(char is2 : is) {
                System.out.print(is2+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'}, 
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        display(board);
        solveSudoku(board);
        display(board);
    }
}
