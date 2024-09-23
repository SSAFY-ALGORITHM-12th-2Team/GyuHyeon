class Solution {
public:
    int minExtraChar(string s, vector<string>& dict) {
        int n = s.size();
        vector<int> dp(n + 1, n + 1);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = 1; j <= i; j++) {
                if (find(dict.begin(), dict.end(), s.substr(i - j, j)) != dict.end()) {
                    dp[i] = min(dp[i], dp[i-j]);
                }
            }
        }

        return dp.back();
    }
};