class Solution {
public:
    int countMatches(vector<vector<string>>& items, string ruleKey, string ruleValue) {
        int idx = (ruleKey == "type" ? 0 : (ruleKey == "color" ? 1 : 2)), ans = 0;
        for (auto item: items) if (item[idx] == ruleValue) ans++;
        return ans;
    }
};