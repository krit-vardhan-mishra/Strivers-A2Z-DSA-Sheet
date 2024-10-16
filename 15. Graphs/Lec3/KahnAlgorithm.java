import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnAlgorithm {
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] inDegree = new int[V];
        List<Integer> topoSort = new ArrayList<>();
        
        // Step 1: Calculate the in-degree of each vertex
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }
        
        // Step 2: Add all vertices with in-degree 0 to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoSort.add(node);
            
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        int[] res = new int[topoSort.size()];
        for (int i=0; i<topoSort.size(); i++) {
            res[i++] = topoSort.get(i);
        }
        
        return res;
    }
}