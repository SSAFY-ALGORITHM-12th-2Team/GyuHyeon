class Solution {
public:
    long long findScore(vector<int>& nums) {
        long long ans = 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
        for (int i = 0; i < nums.size(); i++) pq.push({nums[i], i});
        while (!pq.empty()) {
            ans += pq.top().first;
            nums[pq.top().second] = 0;
            if (pq.top().second > 0) nums[pq.top().second - 1] = 0;
            if (pq.top().second < nums.size() - 1) nums[pq.top().second + 1] = 0;
            pq.pop();
            while (!pq.empty() && nums[pq.top().second] == 0) pq.pop();
        } 
        return ans;
    }
};