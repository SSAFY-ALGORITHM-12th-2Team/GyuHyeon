class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start_node, int end_node) {
        int i = 0;
        vector<vector<pair<int, double>>> g(n);
        for (auto e: edges) {
            g[e[0]].push_back({e[1], succProb[i]});
            g[e[1]].push_back({e[0], succProb[i]});
            i++;
        }
        
        vector<double> dist(n, 0.0);
        priority_queue<pair<double, int>> pq;
        pq.push({1.0, start_node});
        while (!pq.empty()) {
            auto [val, cur] = pq.top();
            pq.pop();
            for (auto [next, w]: g[cur]) {
                if (dist[next] < val * w) {
                    dist[next] = val * w;
                    pq.push({dist[next], next});
                }
            }
        }
        return dist[end_node];
    }
};