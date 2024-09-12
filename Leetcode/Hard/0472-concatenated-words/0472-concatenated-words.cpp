class Solution {
public:
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        unordered_map<string, int> dict;
        for (auto word: words) dict[word]++;
        vector<string> ans;
        for (auto word: words) {
            vector<bool> dp(word.size() + 1, false);
            dp[0] = true;
            for (int i = 0; i < word.size(); i++) {
                if (dp[i]) {
                    string str = "";
                    for (int j = i; j < word.size(); j++) {
                        str += word[j];
                        if (str.size() < word.size() && dict.find(str) != dict.end()) dp[j + 1] = true;
                    }
                }
            }
            if (dp[word.size()]) ans.push_back(word);
        }
        return ans;
    }
};