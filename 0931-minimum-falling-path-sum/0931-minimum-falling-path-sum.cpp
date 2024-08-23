class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n = matrix.size(), ans = INT_MAX;
        vector<vector<int>> dp(n, vector<int>(n, INT_MAX));
        dp[0] = matrix[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int nc = j-1; nc <= j+1; nc++) {
                    if (nc >= 0 && nc < n) dp[i][j] = min(dp[i][j], dp[i-1][nc] + matrix[i][j]);
                }
            }
        }
        for (int j = 0; j < n; j++) ans = min(ans, dp[n-1][j]);
        return ans;
    }
};