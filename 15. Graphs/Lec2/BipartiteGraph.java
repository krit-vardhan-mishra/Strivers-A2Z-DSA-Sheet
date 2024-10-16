import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] colors = new int[V];
        Arrays.fill(colors, 0);

        for (int i = 0; i < V; i++) {
            if (colors[i] == 0 && !bfs(graph, i, colors)) {
                return false;
            }
        }

        return true;
    }

    private boolean bfs(int[][] graph, int i, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        colors[i] = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int n : graph[curr]) {
                if (colors[n] == colors[curr]) {
                    return false;
                } else if (colors[n] == 0) {
                    colors[n] = -colors[curr];
                    queue.add(n);
                }
            }
        }

        return true;
    }
}