import java.util.ArrayList;

public class DetectCycleDFS {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        boolean[] rec = new  boolean[V];

        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                if (isCycle(i, rec, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isCycle(int i, boolean[] parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        if (parent[i]) return true;
        if (visited[i]) return true;
        visited[i] = true;
        parent[i] = true;
        for (int n : adj.get(i)) {
            if (!visited[n]) {
                if (isCycle(n, parent, adj, visited)) return true;
            }
        }
        parent[i] = false;
        return false;
    } 
}
