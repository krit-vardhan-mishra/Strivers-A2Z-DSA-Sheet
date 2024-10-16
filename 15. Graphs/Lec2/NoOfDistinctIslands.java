import java.util.HashSet;

public class NoOfDistinctIslands {

    void dfs(int row, int col, int[][] visited, int[][] grid, StringBuilder shape, int row0, int col0) {
        visited[row][col] = 1;
        shape.append((row - row0) + "," + (col-col0) + ";");
        int n = grid.length;
        int m = grid[0].length;
        int[] hor = {0, -1, 0, 1};
        int[] ver = {1, 0, -1, 0};

        for (int i = 0; i < 4; i++) {
            int newR = hor[i] + row;
            int newC = ver[i] + col;

            if (newR >= 0 && newR < n && newC >= 0 && newC < m && visited[newR][newC] == 0 && grid[newR][newC] == 1) {
                dfs(newR, newC, visited, grid, shape, row0, col0);
            }
        }
    }

    int countDistinctIslands(int[][] grid) {
        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    StringBuilder shape = new StringBuilder();
                    dfs(i, j, visited, grid, shape, i, j);
                    set.add(shape.toString());
                }
            }
        }
        return set.size();
    }
}