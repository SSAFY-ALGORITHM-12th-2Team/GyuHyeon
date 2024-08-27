class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start_node, int end_node) {
        vector<vector<pair<int, double>>> g(n);
        for(int i=0;i<edges.size();i++){
            g[edges[i][0]].push_back({edges[i][1], succProb[i]});
            g[edges[i][1]].push_back({edges[i][0], succProb[i]});
        }
        vector<double> dist(n, 0);
        dist[start_node] = 0;
        priority_queue<pair<double, int>> pq;
        pq.push({1.0, start_node});
        while (!pq.empty()) {
            auto [prob, cur] = pq.top();
            pq.pop();
            if (prob < dist[cur]) continue;
            for (auto [next, val]: g[cur]) {
                if (dist[next] < prob * val) {
                    dist[next] = prob * val;
                    pq.push({dist[next], next});
                }
            }
        }
        return dist[end_node];
    }
};