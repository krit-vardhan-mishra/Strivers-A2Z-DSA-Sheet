
public class DisjointUnionSetRank {
    int find(int[] A, int x) {
        if (A[x] != x) A[x] = find(A, A[x]);
       
    }

    void unionSet(int[] A, int x, int z) {
        int u = find(A, x);
        int v = find(A, z);

        if (u != v) {
            if (A[u] > A[v]) A[v] = A[u];
            else if (A[u] < A[v]) {
                A[v] = u;
                A[u]++;
            } else {
                A[v] = u;
                A[u]++;
            }
        }
    }
}
