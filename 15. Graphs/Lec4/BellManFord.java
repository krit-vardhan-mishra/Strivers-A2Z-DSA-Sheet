
import java.util.ArrayList;
import java.util.Arrays;

public class BellManFord {
    // Bell Man Ford Algorithm helps you to find minimum distance even with negative values.
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] distance = new int[V];
        Arrays.fill(distance, (int)1e8);
        distance[S] = 0;

        for (int i=0; i<V-1; i++) {
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);

                if (distance[u] != 1e8 && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);

            if (distance[u] != 1e8 && distance[u] + weight < distance[v]) {
                return new int[]{-1};
            }
        }

        return distance;

        
    }
}