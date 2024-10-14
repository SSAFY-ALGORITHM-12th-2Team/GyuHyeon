class Solution {
public:
    vector<int> smallestRange(vector<vector<int>>& nums) {
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<>> pq;
        // pair<int, pair<int, int>>
        int max_val = INT_MIN, st = 0, ed = INT_MAX;
        for (int i = 0; i < nums.size(); i++) {
            pq.push({nums[i][0], {i, 0}}); // value, index, element_index
            max_val = max(max_val, nums[i][0]);
        }
        while (pq.size() == nums.size()) {
            auto [val, in] = pq.top();
            pq.pop();
            int i = in.first, j = in.second;
            if (max_val - val < ed - st) {
                st = val;
                ed = max_val;
            }
            if (j + 1 < nums[i].size()) {
                pq.push({nums[i][j+1], {i, j+1}});
                max_val = max(max_val, nums[i][j+1]);
            }
        }
        return {st, ed};
    }
};