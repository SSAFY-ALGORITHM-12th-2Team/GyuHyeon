class Solution {
public:
    vector<int> decrypt(vector<int>& code, int k) {
        if (k == 0) return vector<int>(code.size(), 0);
        vector<int> ans(code.size());
        if (k > 0) {
            for (int i = 0; i < ans.size(); i++) {
                for (int j = 1; j <= k; j++) ans[i] += code[i + j - (i + j >= code.size() ? code.size() : 0)];
            }
        } else {
            k = abs(k);
            for (int i = 0; i < ans.size(); i++) {
                for (int j = 1; j <= k; j++) ans[i] += code[i - j + (i - j < 0 ? code.size() : 0)];
            }
        }
        return ans;
    }
};