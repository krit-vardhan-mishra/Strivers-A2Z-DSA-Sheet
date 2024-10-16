import java.util.ArrayList;

public class NoOfProvinces {

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        int n = V;
        boolean[] p = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!p[i]) {
                find(i, p, adj);
                ans++;
            }
        }

        return ans;
    }

    private static void find(int x, boolean[] p, ArrayList<ArrayList<Integer>> adj) {
        p[x] = true;

        for (int i=0; i<adj.get(0).size(); i++) {
            if (adj.get(x).get(i) == 1 && !p[i]) {
                find(i, p, adj);
            }
        }
    }
}
