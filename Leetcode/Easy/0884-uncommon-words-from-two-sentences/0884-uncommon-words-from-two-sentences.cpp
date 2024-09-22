class Solution {
public:
    vector<string> uncommonFromSentences(string s1, string s2) {
        unordered_map<string, int> m;
        string str = "";
        for (int idx = 0; idx < s1.size(); idx++) {
            if (s1[idx] == ' ') {
                m[str]++;
                str = "";
            } else str += s1[idx];
        }
        if (str != "") m[str]++;
        str = "";
        for (int idx = 0; idx < s2.size(); idx++) {
            if (s2[idx] == ' ') {
                m[str]++;
                str = "";
            } else str += s2[idx];
        }
        if (str != "") m[str]++;
        vector<string> ans;
        for (auto [k, v]: m) {
            if (v == 1) ans.push_back(k);
        }
        return ans;
    }
};