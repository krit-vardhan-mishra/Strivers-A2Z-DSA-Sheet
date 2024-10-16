import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinEffort {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] efforts = new int[row][col];

        for (int i=0; i<row; i++) {
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        pq.offer(new int[]{0, 0, 0});
        efforts[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int effort = curr[0];
            int i = curr[1];
            int j = curr[2];

            if (i == row-1 && j == col-1) return effort;

            for (int[] dir : directions) {
                int newI = i + dir[0];
                int newJ = j + dir[1];

                if (newI >= 0 && newI < row && newJ >= 0 && newJ < col) {
                    int next = Math.max(effort, Math.abs(heights[newI][newJ] - heights[i][j]));

                    if (next < efforts[newI][newJ]) {
                        efforts[newI][newJ] = next;
                        pq.offer(new int[]{next, newI, newJ});
                    }
                }
            }
        }

        return 0;
    }
}
