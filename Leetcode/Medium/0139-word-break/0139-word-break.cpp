class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        map<string, int> dict;
        int n = s.size();
        for (auto word: wordDict) dict[word]++;
        vector<bool> dp(n + 1, false);
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (dp[i]) {
                string str = "";
                for (int j = i; j < n; j++) {
                    str += s[j];
                    if (dict.find(str) != dict.end()) dp[j + 1] = true;
                }
            }
        }
        return dp[n];
    }
};