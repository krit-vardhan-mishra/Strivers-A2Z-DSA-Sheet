import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> reverse = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int[] degree = new int[graph.length];

        for (int i=0; i<graph.length; i++) {
            reverse.add(new ArrayList<>());
        }

        for (int i=0; i<graph.length; i++) {
            for (int n : graph[i]) {
                reverse.get(n).add(i);
                degree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int n : reverse.get(node)) {
                if (--degree[n] == 0) {
                    queue.offer(n);
                }
            }
        }

        Collections.sort(result);
        return result;
    }    
}
