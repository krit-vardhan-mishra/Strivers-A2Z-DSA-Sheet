#include <iostream>
#include <vector>

using namespace std;

bool isCyclic(int i, int parent, vector<int> adj[], vector<bool> &visited) {
    visited[i] = true;
    for (auto n : adj[i]) {
        if (!visited[n]) {
            if (isCyclic(n, i, adj, visited)) return true;
        } else if (n != parent) {
            return true;
        }
    }
    return false;
}

bool isCycle(int V, vector<int> adj[]) {
    vector<bool> visited(V, false);

    for (int i = 0; i < V; i++) {
        if (!visited[i]) {
            if (isCyclic(i, -1, adj, visited)) {
                return true;
            }
        }
    }
    return false;
}

int main() {
    int V = 5;
    vector<int> adj[V];

    // Example graph
    adj[0].push_back(1);
    adj[1].push_back(0);
    adj[1].push_back(2);
    adj[2].push_back(1);
    adj[2].push_back(3);
    adj[3].push_back(2);
    adj[3].push_back(4);
    adj[4].push_back(3);

    if (isCycle(V, adj))
        cout << "Graph contains cycle";
    else
        cout << "Graph doesn't contain cycle";

    return 0;
}
