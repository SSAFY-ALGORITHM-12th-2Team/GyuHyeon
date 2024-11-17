class Solution {
public:
    vector<int> maximumBeauty(vector<vector<int>>& items, vector<int>& queries) {
        map<int, int> m;
        int idx = 0;
        vector<int> ans(queries.size(), 0);
        for (auto item: items) m[item[0]] = max(m[item[0]], item[1]);
        sort(items.begin(), items.end());
        int b = 0;
        for (auto& item: items) {
            b = max(b, item[1]);
            item[1] = b;
        }
        for (auto q: queries) {
            int l = 0, r = items.size() - 1, mid;
            while (l <= r) {
                mid = (l + r) / 2;
                if (items[mid][0] > q) r = mid - 1;
                else {
                    ans[idx] = max(ans[idx], items[mid][1]);
                    l = mid + 1;
                }
            }
            idx++;
        }

        return ans;
    }
};