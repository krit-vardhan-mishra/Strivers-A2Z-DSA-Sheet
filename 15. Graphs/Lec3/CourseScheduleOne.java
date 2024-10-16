
import java.util.List;
import java.util.ArrayList;

public class CourseScheduleOne {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            adj.get(pair[1]).add(pair[0]);
        }
        
        // Return true if no cycle is detected
        return !isCyclic(numCourses, adj);
    }
    
    public boolean isCyclic(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
    
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int v, List<List<Integer>> adj, boolean[] visited, boolean[] recStack) {
        visited[v] = true;
        recStack[v] = true;
    
        for (Integer neighbor : adj.get(v)) {
            if (!visited[neighbor] && dfs(neighbor, adj, visited, recStack)) {
                return true;
            } else if (recStack[neighbor]) {
                return true;
            }
        }
    
        recStack[v] = false;
        return false;
    }
    
}
