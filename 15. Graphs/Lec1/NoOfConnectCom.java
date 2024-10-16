

public class NoOfConnectCom {
    public int countComponents(int n, int[][] edges) {
        int[] p = new int[n];
        
        for (int i = 0; i<n; i++) {
            p[i] = i;
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            p[find(a, p)] = find(b, p);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (i == find(i, p)) ans++;
        }

        return ans;
    }

    private int find(int x, int[] p) {
        if (p[x] != x) {
            p[x] = find(p[x], p);
        }

        return p[x];
    }
}
