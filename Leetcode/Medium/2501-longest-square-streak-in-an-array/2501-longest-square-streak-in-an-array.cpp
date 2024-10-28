class Solution {
public:
    int longestSquareStreak(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<int> dp(nums.back() + 1, 0);
        int ans = 1;
        for (auto num: nums) {
            int sq = sqrt(num);
            double dsq = sqrt(num);
            if ((double) sq == dsq) dp[num] = dp[sq] + 1;
            else dp[num] = 1;
            ans = max(ans, dp[num]);
        }
        return ans == 1 ? -1 : ans;
    }
};