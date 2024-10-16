
import java.util.PriorityQueue;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

class DisjointSet {
    int[] parent, rank;
    
    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); // Path compression
        }
        return parent[node];
    }
    
    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
}

class PrismAlgorithm {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here
        boolean[] visited = new boolean[V];
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0});

        int totalWeight = 0;

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[1];

            if (visited[u]) continue;

            visited[u] = true;
            totalWeight += node[0];

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                if (!visited[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.add(new int[]{key[v], v});
                }
            }
        }

        return totalWeight;
    }
}

class KruskalAlgorithm {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here
        List<int[]> edges = new ArrayList<>();

        for (int i=0; i<V; i++) {
            for (int[] neighbor : adj.get(i)) {
                int j = neighbor[0];
                int weight = neighbor[1];
                edges.add(new int[]{i, j, weight});
            }
        }

        edges.sort(Comparator.comparing(a -> a[2]));

        DisjointSet ds = new DisjointSet(V);
        int totalWeight = 0;
        int edgeCount = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            if (ds.find(u) != ds.find(v)) {
                ds.union(u, v);
                totalWeight += weight;
                edgeCount++;

                if (edgeCount == V-1) break;
            }
        }

        return totalWeight;
    }
}

public class MinSpanningTree {
}