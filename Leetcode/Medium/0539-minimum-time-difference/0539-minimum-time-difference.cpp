class Solution {
public:
    int findMinDifference(vector<string>& timePoints) {
        vector<int> t(timePoints.size());
        for (int i = 0; i < t.size(); i++) {
            int hr = stoi(timePoints[i].substr(0, 2)), mn = stoi(timePoints[i].substr(3, 2));
            t[i] = hr * 60 + mn;
        }
        sort(t.begin(), t.end());
        int n = t.size(), ans = min(t[0] + 1440 - t[n-1], t[n-1] - t[0]);
        for (int i = 1; i < n; i++) {
            ans = min({ans, t[i] - t[i-1], t[i-1] + 1440 - t[i]});
        }
        return ans;
    }
};