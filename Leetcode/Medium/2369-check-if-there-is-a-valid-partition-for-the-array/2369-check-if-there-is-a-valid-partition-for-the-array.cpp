class Solution {
public:
    bool validPartition(vector<int>& nums) {
        int n = nums.size();
        vector<bool> dp(n+1, false);
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            if (dp[i - 1]) {
                if (i + 1 <= n && nums[i-1] == nums[i]) dp[i+1] = true;
                if (i + 2 <= n && ((nums[i-1] == nums[i] && nums[i] == nums[i+1]) || (nums[i-1] + 1 == nums[i] && nums[i] + 1 == nums[i+1]))) dp[i+2] = true;
            }
        }
        return dp[n];
    }
};