import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestUndirectedGraph {

    public static int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>(m);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        distance[src] = 0;
        visited[src] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    distance[neighbor] = distance[node] + 1;
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int[][] ed = { { 0, 1 }, { 0, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 1, 2 }, { 2, 6 }, { 6, 7 }, { 7, 8 },
                { 6, 8 } };
        int[] result = shortestPath(ed, 9, 10, 0);
        for (int res : result) {
            System.out.println(res);
        }
    }
}