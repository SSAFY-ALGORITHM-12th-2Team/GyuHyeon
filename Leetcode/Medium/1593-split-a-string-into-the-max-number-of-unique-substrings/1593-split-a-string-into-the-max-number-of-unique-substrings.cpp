class Solution {
public:
    int n, ans = 0;
    set<string> st;
    int maxUniqueSplit(string s) {
        n = s.size();
        split(s, 0, 0);
        return ans;
    }
    void split(string s, int idx, int cnt) {
        string str = "";
        for (int i = idx; i < n; i++) {
            str += s[i];
            if (!st.insert(str).second) continue;
            split(s, i+1, cnt+1);
            st.erase(str);
        }
        ans = max(ans, cnt);
    }
};