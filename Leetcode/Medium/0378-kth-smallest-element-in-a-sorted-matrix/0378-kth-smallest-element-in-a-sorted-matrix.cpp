class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<>> pq;
        for (int i = 0; i < matrix.size(); i++) pq.push({matrix[i][0], {i, 0}});
        while (--k && !pq.empty()) {
            pair<int, int> cur = pq.top().second;
            pq.pop();
            if (cur.second < matrix[cur.first].size() - 1) pq.push({matrix[cur.first][cur.second+1], {cur.first, cur.second+1}});
        }
        return pq.top().first;
    }
};