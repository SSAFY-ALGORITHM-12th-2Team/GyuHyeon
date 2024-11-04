class Solution {
public:
    int maxMoves(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size(), ans = 0;
        vector<vector<int>> dp(m, vector<int>(n, 0));
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = (grid[j][i+1] > grid[j][i] ? dp[i+1][j] + 1 : 0);
                if (j > 0 && grid[j][i] < grid[j-1][i+1]) dp[i][j] = max(dp[i][j], dp[i+1][j-1]+1);
                if (j + 1 < n && grid[j][i] < grid[j+1][i+1]) dp[i][j] = max(dp[i][j], dp[i+1][j+1]+1);
            }
        }
        return *max_element(dp[0].begin(), dp[0].end());
    }
};