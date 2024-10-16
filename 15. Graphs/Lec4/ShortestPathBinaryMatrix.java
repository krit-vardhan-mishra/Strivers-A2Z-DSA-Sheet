import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n-1][n-1] != 0) {
            return -1;
        }

        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];
            int distance = curr[2];

            if (i == n-1 && j == n-1) return distance;

            for (int[] dir : directions) {
                int newI = i + dir[0];
                int newJ = j + dir[1];
    
                if (newI >= 0 && newI < n && newJ >= 0 && newJ < n && grid[newI][newJ] == 0) {
                    grid[newI][newJ] = 1;
                    queue.offer(new int[]{newI, newJ, distance + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
