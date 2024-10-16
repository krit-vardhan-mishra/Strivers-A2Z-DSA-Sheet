import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleTwo {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> topoSort = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 1: Calculate the in-degree of each vertex
        // and Creating adj list
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
        }
        
        // Step 2: Add all vertices with in-degree 0 to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
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
        
        if (topoSort.size() != numCourses) {
            return new int[0];
        }

        int[] res = new int[topoSort.size()];
        for (int i=0; i<topoSort.size(); i++) {
            res[i] = topoSort.get(i);
        }
        
        return res;
    }
}
