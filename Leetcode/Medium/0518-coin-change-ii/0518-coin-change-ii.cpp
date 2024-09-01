class Solution {
public:
    int n;
    vector<vector<int>> dp;
    int solve(vector<int>& coins, int idx, int amount) {
        if (amount == 0) return 1;
        if (idx >= n) return 0;
        if (dp[idx][amount] != -1) return dp[idx][amount];
        int val = 0, val2 = 0;
        if (amount - coins[idx] >= 0) val = solve(coins, idx, amount - coins[idx]);
        val2 = solve(coins, idx+1, amount);
        return dp[idx][amount] = val + val2;
    }
    int change(int amount, vector<int>& coins) {
        n = coins.size();
        dp = vector<vector<int>>(n, vector<int>(amount+1, -1));
        return solve(coins, 0, amount);
    }
};