class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        priority_queue<vector<int>, vector<vector<int>>, greater<>> pq;
        for (auto num1: nums1) {
            for (auto num2: nums2) pq.push(vector<int>{num1+num2, num1, num2});
        }
        vector<vector<int>> ans(k);
        int i = 0;
        while (!pq.empty() && i < k) {
            ans[i++] = {pq.top()[1], pq.top()[2]};
            pq.pop();
        }
        return ans;
    }
};