import java.util.ArrayList;

public class CycleDetectionBFS {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];

        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                if (isCycle(i, -1, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isCycle(int i, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[i] = true;
        for (int n : adj.get(i)) {
            if (!visited[n]) {
                if (isCycle(n, i, adj, visited)) return true;
            } else if (n != parent) {
                return true;
            }
        }

        return false;
    }
    
}
