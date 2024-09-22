class Solution {
public:
    int maxMoves(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size(), ans = 0;
        vector<vector<int>> dp(n, vector<int>(m, 0));
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < m; j++) {
                if (i-1 >= 0 && grid[i][j] > grid[i-1][j-1]) dp[i][j] = max(dp[i][j], dp[i-1][j-1]+1);
                if (grid[i][j] > grid[i][j-1]) dp[i][j] = max(dp[i][j], dp[i][j-1]+1);
                if (i+1 < n && grid[i][j] > grid[i+1][j-1]) dp[i][j] = max(dp[i][j], dp[i+1][j-1]+1);
                if (dp[i][j] == 0) break;
                ans = max(ans, dp[i][j] - 1);
            }
        }
        return ans;
    }
};