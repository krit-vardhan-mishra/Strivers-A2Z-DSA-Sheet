#include<bits/stdc++.h>

using namespace std;

public:
    vector<vector<int>> printGraph(int V, vector<pair<int, int>> edges) {
        vector<vector<int>> ans(V);

        for (int i=0; i<edges.size(); i++) {
            int one = edges[i].first;
            int two = edges[i].second;
            ans[one].push_back(two);
            ans[two].push_back(one);
        }

        return ans;
    }
