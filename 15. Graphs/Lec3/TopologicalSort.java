import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] degree = new int[V];

        for (ArrayList<Integer> list : adj) {
            for (Integer i : list) {
                degree[i]++;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        sort(adj, V, ans, degree);

        int[] result = new int[ans.size()];
        for (int i=0; i<ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    private static void sort(ArrayList<ArrayList<Integer>> adj, int v, ArrayList<Integer> ans, int[] degree) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            ans.add(curr);

            for (int i : adj.get(curr)) {
                if (--degree[i] == 0) {
                    queue.offer(i);
                }
            }
        }
    }    
}
