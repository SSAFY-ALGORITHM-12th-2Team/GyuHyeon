class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
        map<char, int> m;
        int ans = 0;
        for (auto a: allowed) m[a]++;
        for (auto word: words) {
            bool flag = true;
            for (auto c: word) {
                if (m.find(c) == m.end()) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans++;
        }
        return ans;
    }
};