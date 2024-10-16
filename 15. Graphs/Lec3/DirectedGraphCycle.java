import java.util.ArrayList;

public class DirectedGraphCycle {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[V];
        boolean[] rec = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, rec)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] rec) {
        visited[v] = true;
        rec[v] = true;

        for (Integer n : adj.get(v)) {
            if (!visited[n] && dfs(n, adj, visited, rec)) {
                    return true;
            } else if (rec[n]) {
                return true;
            }
        }

        rec[v] = false;
        return false;
    }
}
