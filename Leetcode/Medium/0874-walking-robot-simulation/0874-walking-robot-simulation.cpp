class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        map<pair<int, int>, int> m;
        for (auto o: obstacles) m[{o[0], o[1]}]++;
        vector<vector<int>> dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int d = 0, x = 0, y = 0, ans = 0;
        for (auto c: commands) {
            if (c == -1) d = (++d >= 4 ? 0 : d);
            else if (c == -2) d = (--d < 0 ? 3 : d);
            else {
                for (int cnt = 1; cnt <= c; cnt++) {
                    if (m[{x + dir[d][0], y + dir[d][1]}]) break;
                    else {
                        x += dir[d][0];
                        y += dir[d][1];
                        ans = max(ans, x * x + y * y);
                    }
                }
            }
        }
        return ans;
    }
};