class Solution {
public:
    long long maxKelements(vector<int>& nums, int k) {
        long long ans = 0;
        priority_queue<int> pq;
        for (auto i: nums) pq.push(i);
        while (k-- > 0) {
            ans += pq.top();
            pq.push(ceil((double)pq.top() / 3));
            pq.pop();
            cout << ans << endl;
        }
        return ans;
    }
};