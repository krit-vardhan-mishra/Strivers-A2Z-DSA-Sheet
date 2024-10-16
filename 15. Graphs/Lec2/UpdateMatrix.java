import java.util.*;

public class UpdateMatrix {

    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            // Move Down
            if (x + 1 < mat.length && result[x + 1][y] > result[x][y] + 1) {
                result[x + 1][y] = result[x][y] + 1;
                queue.offer(new int[]{x + 1, y});
            }

            // Move Up
            if (x - 1 >= 0 && result[x - 1][y] > result[x][y] + 1) {
                result[x - 1][y] = result[x][y] + 1;
                queue.offer(new int[]{x - 1, y});
            }

            // Move Right
            if (y + 1 < mat[0].length && result[x][y + 1] > result[x][y] + 1) {
                result[x][y + 1] = result[x][y] + 1;
                queue.offer(new int[]{x, y + 1});
            }

            // Move Left
            if (y - 1 >= 0 && result[x][y - 1] > result[x][y] + 1) {
                result[x][y - 1] = result[x][y] + 1;
                queue.offer(new int[]{x, y - 1});
            }

        }
        
        return result;
    }
}
