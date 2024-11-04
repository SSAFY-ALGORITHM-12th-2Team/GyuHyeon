class Solution {
public:
    int n;
    string longestPalindrome(string s) {
        n = s.size();
        string ans = "";
        for (int i = 0; i < n - 1; i++) {
            string tmp = getMaxlen(s, i-1, i+1, 1);
            if (tmp.size() > ans.size()) ans = tmp;

            if (s[i] == s[i+1]) tmp = getMaxlen(s, i-1, i+2, 2);
            if (tmp.size() > ans.size()) ans = tmp;
        }
        return ans;
    }
    string getMaxlen(string s, int lo, int hi, int len) {
        while (lo >= 0 && hi < n) {
            if (s[lo] == s[hi]) len += 2;
            else break;
            lo--;
            hi++;
        }
        return s.substr(lo + 1, len);
    }
};