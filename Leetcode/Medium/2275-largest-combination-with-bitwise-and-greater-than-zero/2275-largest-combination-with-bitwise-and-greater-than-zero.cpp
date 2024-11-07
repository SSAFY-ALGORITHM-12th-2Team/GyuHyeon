class Solution {
public:
    int largestCombination(vector<int>& candidates) {
        vector<int> memo(24, 0);
        int ans = 0;
        for (auto c: candidates) {
            for (int i = 0; i < 24; i++) {
                if ((c >> i) % 2 == 1) memo[i]++;
                ans = max(ans, memo[i]);
            }
        }
        return ans;
    }
};