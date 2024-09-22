
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == arr[0] && func(board, i, j, 0, arr)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean func(char[][] board, int i, int j, int idx, char[] word) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] == '#'
                || board[i][j] != word[idx])
            return false;
        if (idx == word.length - 1)
            return true;

        char ch = board[i][j];
        board[i][j] = '#';

        boolean res = func(board, i + 1, j, idx + 1, word) || func(board, i - 1, j, idx + 1, word)
                || func(board, i, j - 1, idx + 1, word) || func(board, i, j + 1, idx + 1, word);
        board[i][j] = ch;
        return res;
    }

    public static void main(String[] args) {
        char[][] charArr = { { 'A', 'B', 'C', 'D' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";
        System.out.println(exist(charArr, word));
    }
}
