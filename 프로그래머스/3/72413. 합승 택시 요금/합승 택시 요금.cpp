#include <bits/stdc++.h>

using namespace std;

vector<int> dijkstra(int& n, vector<vector<pair<int, int>>>& g, int s) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
    pq.push({0, s});
    vector<int> dist(n+1, INT_MAX);
    dist[s] = 0;
    while (!pq.empty()) {
        auto [val, cur] = pq.top();
        pq.pop();
        if (val > dist[cur]) continue;
        for (auto next: g[cur]) {
            if (next.second + val < dist[next.first]) {
                dist[next.first] = next.second + val;
                pq.push({dist[next.first], next.first});
            }
        }
    }
    return dist;
}

int solution(int n, int s, int a, int b, vector<vector<int>> fares) {
    int answer = INT_MAX;
    vector<vector<pair<int, int>>> g(n+1);
    for (auto fare: fares) {
        g[fare[0]].push_back({fare[1], fare[2]});
        g[fare[1]].push_back({fare[0], fare[2]});
    }
    vector<int> ds = dijkstra(n, g, s), da = dijkstra(n, g, a), db = dijkstra(n, g, b);
    
    for (int i = 1; i <= n; i++) answer = min(answer, ds[i] + da[i] + db[i]);
    
    return answer;
}