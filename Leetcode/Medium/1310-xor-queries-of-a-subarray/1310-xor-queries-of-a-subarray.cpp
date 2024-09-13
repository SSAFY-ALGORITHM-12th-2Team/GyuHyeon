class Solution {
public:
    vector<int> xorQueries(vector<int>& arr, vector<vector<int>>& queries) {
        int n = queries.size(), idx = 0;
        vector<int> ans(n), pf(arr.size() + 1, 0);
        for (int i = 1; i < pf.size(); i++) pf[i] = pf[i-1] ^ arr[i-1];
        for (auto q: queries) ans[idx++] = pf[q[1] + 1] ^ pf[q[0]];
        return ans;
    }
};