import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V+1];
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.add(0);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u);

            for (int n : adj.get(u)) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        return result;
    }
}
