
public class FindCircleNum {

    private int[][] temp;
    private boolean[] visited;

    public int findCircleNum(int[][] isConnected) {
        temp = isConnected;
        int n = temp.length;
        visited = new boolean[n];
        int ans = 0;

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(i);
                ans++;
            }
        }
        return ans;
    }

    private void dfs(int n) {
        visited[n] = true;

        for (int i = 0; i < temp.length; i++) {
            if (!visited[i] && temp[n][i] == 1) {
                dfs(i);
            }
        }
    }
}
