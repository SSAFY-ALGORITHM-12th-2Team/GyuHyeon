class Solution {
public:
    string longestDiverseString(int a, int b, int c) {
        priority_queue<pair<int, char>> pq;
        if (a != 0) pq.push({a, 'a'});
        if (b != 0) pq.push({b, 'b'});
        if (c != 0) pq.push({c, 'c'});
        string ans = "";
        while (!pq.empty()) {
            if (ans.size() < 2 || (ans[ans.size() - 2] != ans[ans.size() - 1] || ans[ans.size()-2] != pq.top().second)) {
                ans += pq.top().second;
                if (pq.top().first - 1 > 0) pq.push({pq.top().first - 1, pq.top().second});
                pq.pop();
            } else {
                pair<int, char> cur = pq.top();
                pq.pop();
                if (!pq.empty()) {
                    ans += pq.top().second;
                    pair<int, char> cur2 = {pq.top().first - 1, pq.top().second};
                    pq.pop();
                    if (cur2.first > 0) pq.push(cur2);
                }
                else cur.first--;
                if (cur.first > 0) pq.push(cur);
            }
        }
        return ans;
    }
};