#include <bits/stdc++.h>

using namespace std;

int solution(int N, vector<vector<int>> road, int K) {
    int answer = 0;
    
    vector<vector<pair<int,int>>> g(N+1);
    for (auto r: road) {
        g[r[0]].push_back({r[1], r[2]});
        g[r[1]].push_back({r[0], r[2]});
    }
    
    vector<int> dist(N+1, INT_MAX);
    dist[1] = 0;
    priority_queue<pair<int, int>> pq;
    pq.push({1, 0});
    while (!pq.empty()) {
        auto [cur, val] = pq.top();
        pq.pop();
        
        for (int i = 0; i < g[cur].size(); i++) {
            if (g[cur][i].second + dist[cur] < dist[g[cur][i].first]) {
                pq.push(g[cur][i]);
                dist[g[cur][i].first] = g[cur][i].second + dist[cur];
            }
        }
    }
    
    for (int i = 1; i <= N; i++) if (dist[i] <= K) answer++;

    return answer;
}