import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Pair {
    int to, distance;

    Pair(int to, int distance) {
        this.to = to;
        this.distance = distance;
    }
}

public class ShortestPathDAG {

    public int[] shortestPath(int N, int M, int[][] edges) {
        // Code here
        int[] distance = new int[N];
        Queue<Pair> queue = new LinkedList<>();
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int dist = edge[2];
            adj.get(from).add(new Pair(to, dist));
        }

        Arrays.fill(distance, Integer.MAX_VALUE);
        queue.offer(new Pair(0, 0));
        distance[0] = 0;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int to = p.to;
            int dist = p.distance;

            for (Pair neighbor : adj.get(to)) {
                int next = neighbor.to;
                int weight = neighbor.distance;

                if (weight + dist < distance[next]) {
                    distance[next] = weight + dist;
                    queue.offer(new Pair(next, distance[next]));
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