import java.util.Deque;
import java.util.LinkedList;

public class RottingOranges {

    // Time Complexity : (N x M)
    // Space Complexityn : (N x M)
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int fresh = 0;
        Deque<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int time = 0;

        while (!queue.isEmpty() && fresh > 0) {
            time++;

            for (int i = queue.size(); i > 0; i--) {
                int[] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];
                
                // top
                if (x > 0 && grid[x-1][y] == 1){
                    grid[x-1][y] = 2;
                    fresh--;
                    queue.offer(new int[] {x-1, y});
                }
                
                // bottom
                if (x < grid.length-1 && grid[x+1][y] == 1) {
                    grid[x+1][y] = 2;
                    fresh--;
                    queue.offer(new int[] {x+1, y});
                }

                // right
                if (y < grid[0].length-1 && grid[x][y+1] == 1) {
                    grid[x][y+1] = 2;
                    fresh--;
                    queue.offer(new int[] {x, y+1});
                }

                if (y > 0 && grid[x][y-1] == 1){
                    grid[x][y-1] = 2;
                    fresh--;
                    queue.offer(new int[] {x, y-1});
                }
            }
        }

        return fresh > 0 ? -1 : time;
    }

    /*
        // Time Complexity : (N x M) * 2
        // Space Complexityn : (N x M)
        * // int[] fresh = {0};
    // public int orangesRotting(int[][] edges) {
    // int time = 0;
    // for (int i = 0; i < edges.length; i++) {
    // for (int j = 0; j < edges[0].length; j++) {
    // if (edges[i][j] == 1) {
    // fresh[0]++;
    // }
    // }
    // }
    // if (fresh[0] == 0) return 0;
    
    // int[] mat = {0};
    // boolean temp = true;
    // while (temp) {
    // temp = false;
    // int count = mat[0];
    // for (int i = 0; i < edges.length; i++) {
    // for (int j = 0; j < edges[0].length; j++) {
    // if (edges[i][j] == 2) {
    // rotting(edges, i, j, mat, fresh);
    // }
    // }
    // }
    // if (mat[0] > count) {
    // time++;
    // temp = true;
    // }
    
    // for (int i = 0; i < edges.length; i++) {
    // for (int j = 0; j < edges[0].length; j++) {
    // if (edges[i][j] == 3) {
    // edges[i][j] = 2;
    // }
    // }
    // }
    // }
    
    // return fresh[0] == 0 ? time : -1;
    // }
    
    // public void rotting(int[][] edges, int i, int j, int[] mat, int[]
    fresh) {
    // if (i > 0 && edges[i-1][j] == 1) {
    // edges[i-1][j] = 3;
    // mat[0]++;
    // fresh[0]--;
    // }
    // if (j > 0 && edges[i][j-1] == 1) {
    // edges[i][j-1] = 3;
    // mat[0]++;
    // fresh[0]--;
    // }
    // if (i < edges.length-1 && edges[i+1][j] == 1) {
    // edges[i+1][j] = 3;
    // mat[0]++;
    // fresh[0]--;
    // }
    // if (j < edges[0].length-1 && edges[i][j+1] == 1) {
    // edges[i][j+1] = 3;
    // mat[0]++;
    // fresh[0]--;
    // }
    // }
    */
}