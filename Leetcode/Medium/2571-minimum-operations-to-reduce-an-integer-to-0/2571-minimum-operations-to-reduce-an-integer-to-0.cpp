class Solution {
public:
    int minOperations(int n) {
        int ans = 0;
        while (n > 0) {
            int i = 1;
            while (pow(2, i) <= n) i++;
            n = min(abs(n - pow(2, i)), abs(n - pow(2, i-1)));
            ans++;
        }
        return ans;
    }
};