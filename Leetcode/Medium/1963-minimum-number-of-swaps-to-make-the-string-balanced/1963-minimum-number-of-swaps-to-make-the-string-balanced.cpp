class Solution {
public:
    int minSwaps(string s) {
        int n = s.size(), ans = 0, lo = 0, hi = n - 1, so = 0, ec = 0;
        while (lo < hi) {
            if (s[lo] == ']' && s[hi] == '[') {
                if (so > 0 && ec > 0) {
                    so--;
                    ec--;
                }
                else {
                    ans++;
                    so++;
                    ec++;
                }
            }
            else if (s[lo] == ']' && s[hi] == ']') {
                ec++;
                hi--;
                continue;
            }
            else if (s[lo] == '[' && s[hi] == '[') {
                so++;
                lo++;
                continue;
            }
            if (s[lo] == '[') so++;
            if (s[hi] == ']') ec++;
            lo++;
            hi--;
        }
        return ans;
    }
};