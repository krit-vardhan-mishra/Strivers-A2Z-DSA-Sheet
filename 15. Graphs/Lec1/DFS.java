
import java.util.*;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfs(0, adj, ans, visited);
        return ans;
    }

    private void dfs(int i, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, boolean[] visited) {
        for (int n : adj.get(i)) {
            if (!visited[n]) {
                ans.add(i);
                visited[i] = true;
                dfs(n, adj, ans, visited);
            }
        }
    }
}
