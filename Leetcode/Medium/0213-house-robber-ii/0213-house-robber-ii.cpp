class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size(), ans = 0;
        if (n == 1) return nums[0];
        vector<int> dp(n, 0);
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < n - 1; i++) {
            for (int j = i - 2; j >= 0; j--) dp[i] = max(dp[i], dp[j] + nums[i]);
        }
        for (int j = n - 3; j >= 0; j--) dp[n-1] = max(dp[n-1], dp[j]);
        ans = max(dp[n-1], dp[n-2]);
        dp = vector<int>(n, 0);
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            for (int j = i - 2; j >= 0; j--) dp[i] = max(dp[i], dp[j] + nums[i]);
        }
        ans = max({ans, dp[n-1], dp[n-2]});
        return ans;
    }
};