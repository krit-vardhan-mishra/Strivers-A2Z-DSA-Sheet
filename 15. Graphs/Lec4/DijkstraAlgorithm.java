import java.util.*;

public class DijkstraAlgorithm {

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, S });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currDist = current[0];
            int node = current[1];

            for (ArrayList<Integer> neighbor : adj.get(node)) {
                int nextNode = neighbor.get(0);
                int weight = neighbor.get(1);

                if (currDist + weight < distance[nextNode]) {
                    distance[nextNode] = currDist + weight;
                    pq.offer(new int[] { distance[nextNode], nextNode });
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }
}