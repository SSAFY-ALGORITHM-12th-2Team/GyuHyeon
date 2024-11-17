class Solution {
public:
    int minimizedMaximum(int n, vector<int>& quantities) {
        long long lo = 0, hi = 0, mid; 
        for (auto q: quantities) hi += q;
        mid = hi / n;
        while (lo < hi && mid != 0) {
            long long cur = 0;
            for (auto q: quantities) cur += (q / mid) + (q % mid > 0 ? 1 : 0);
            if (cur > n) lo = mid + 1;
            else if (cur <= n) hi = mid;
            mid = (lo + hi) / 2;
        }
        return hi;
    }
};