class Solution {
public:
    vector<int> missingRolls(vector<int>& rolls, int mean, int n) {
        vector<int> ans;
        int sum = 0, num = rolls.size() + n;
        for (auto r: rolls) sum += r;
        int total = num * mean - sum;
        if (total < n || total > n * 6) return ans;
        ans = vector<int>(n, total / n);
        int res = total % n, i = 0;
        while (res-- > 0) {
            ans[i++]++;
            if (i >= n) i = 0;
        }
        return ans;
    }
};