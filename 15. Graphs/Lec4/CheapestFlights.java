import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CheapestFlights {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Map<Integer, ArrayList<int[]>> graph = new HashMap<>();

        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        distance[src] = 0;
        int steps = 0;

        while (!queue.isEmpty() && steps <= k) {
            int N = queue.size();

            while (N-- > 0) {
                int[] curr = queue.poll();
                int u = curr[0];
                int price = curr[1];

                if (graph.containsKey(u)) {
                    for (int[] neigbhor : graph.get(u)) {
                        int newCity = neigbhor[0];
                        int newPrice = neigbhor[1];
                        
                        if (distance[newCity] > price + newPrice) {
                            distance[newCity] = price + newPrice;
                            queue.offer(new int[]{newCity, price + newPrice});
                        }
                    }
                }
            }
            steps++;
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }

}