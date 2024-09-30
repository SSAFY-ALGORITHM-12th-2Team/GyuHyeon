#include <string>
#include <vector>
#include <map>
#include <queue>
#include <iostream>

using namespace std;

struct robot {
    int robot_no;
    int route_idx;
    pair<int, int> cur;
};

int solution(vector<vector<int>> points, vector<vector<int>> routes) {
    int ans = 0, len = routes.size();
    queue<robot> q;
    map<pair<int, int>, int> m;
    for (int i = 0; i < routes.size(); i++) {
        robot r;
        r.robot_no = i;
        r.route_idx = 1;
        r.cur = {points[routes[i][0] - 1][0], points[routes[i][0] - 1][1]};
        if (m[r.cur] == 1) ans++;
        m[r.cur]++;
        q.push(r);
    }
    while (!q.empty() && len > 0) {
        int size = len;
        while (size--) {
            robot r = q.front();
            if (--m[r.cur] == 0) m.erase(r.cur);
            if (points[routes[r.robot_no][r.route_idx] - 1][0] == r.cur.first && points[routes[r.robot_no][r.route_idx] - 1][1] == r.cur.second) r.route_idx++;
            int x = points[routes[r.robot_no][r.route_idx] - 1][0], y = points[routes[r.robot_no][r.route_idx] - 1][1];
            if (r.route_idx < routes[r.robot_no].size()) {
                if (x - r.cur.first > 0) r.cur.first += 1;
                else if (x - r.cur.first < 0) r.cur.first -= 1;
                else if (y - r.cur.second > 0) r.cur.second += 1;
                else if (y - r.cur.second < 0) r.cur.second -= 1;
                m[r.cur]++;
                q.push(r);
            }
            else len--;
            q.pop();
        }
        for (auto [k, v]: m) if (v > 1) ans++;
    }
    return ans;
}