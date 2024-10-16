
public class FlyodWarshallAlgorithm {
    public void shortest_distance(int[][] matrix)
    {
        // Code here
        int V = matrix.length;
        for (int i=0; i<V; i++) {
            for (int j=0; j<V; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int)(1e9);
                }
                if (i == j) matrix[i][j] = 0;
            }
        }

        for (int k=0; k<V; k++) {
            for (int i=0; i<V; i++) {
                for (int j=0; j<V; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for (int i=0; i<V; i++) {
            for (int j=0; j<V; j++) {
                if (matrix[i][j] == (int)(1e9)) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
}
