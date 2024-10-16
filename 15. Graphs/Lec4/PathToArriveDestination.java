import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PathToArriveDestination {

    public int countPaths(int n, int[][] roads) {
        Map<Integer, ArrayList<int[]>> adj = new HashMap<>();

        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            int distance = road[2];

            adj.putIfAbsent(from, new ArrayList<>());
            adj.putIfAbsent(to, new ArrayList<>());
            adj.get(from).add(new int[]{to, distance});
            adj.get(to).add(new int[]{from, distance});
        }

        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[0] = 0;

        int mod = (int) 1e9 + 7;
        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long currDist = curr[1];

            if (currDist > distance[node]) continue;

            for (int[] neighbor : adj.get(node)) {
                int next = neighbor[0];
                long dist = currDist + neighbor[1];

                if (dist < distance[next]) {
                    distance[next] = dist;
                    pq.offer(new long[]{next, dist});
                    ways[next] = ways[node];
                } else if (dist == distance[next]) {
                    ways[next] = (ways[next] + ways[node] % mod);
                }
            }
        }

        return ways[n-1];
    }
}