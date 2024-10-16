import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, ArrayList<int[]>> adj = new HashMap<>();

        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int timeTaken = time[2];

            adj.putIfAbsent(from, new ArrayList<>());
            adj.get(from).add(new int[]{to, timeTaken});
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{k, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int to = curr[0];
            int time = curr[1];

            if (adj.containsKey(to)) {
                for (int[] neigbhor : adj.get(to)) {
                    int newTo = neigbhor[0];
                    int newTime = neigbhor[1];

                    if (distance[newTo] > time + newTime) {
                        distance[newTo] = time + newTime;
                        queue.offer(new int[]{newTo, distance[newTo]});
                    }
                }
            }
        }

        int maxTime = Arrays.stream(distance).skip(1).max().getAsInt();
        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }
    
    // 1 ---- 2 {1}
    // 1 ---- 2 {1} 

    // 2, 1, 1
    // 2, 3, 1
    // 3, 4, 1
}
