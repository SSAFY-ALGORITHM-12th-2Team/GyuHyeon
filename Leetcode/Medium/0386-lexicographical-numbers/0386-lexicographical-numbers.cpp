class Solution {
public:
    int n;
    vector<int> ans;
    void solve(int num) {
        for (int i = 0; i <= 9; i++) {
            int next = num * 10 + i;
            if (next > n) return;
            ans.push_back(next);
            solve(next);
        }
    }
    vector<int> lexicalOrder(int n) {
        this->n = n;
        for (int i = 1; i <= 9; i++) {
            if (i > n) break;
            ans.push_back(i);
            solve(i);
        }
        return ans;
    }
};