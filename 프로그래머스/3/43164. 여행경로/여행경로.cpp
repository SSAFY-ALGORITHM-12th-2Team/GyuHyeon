#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<string> ans;

void search(vector<vector<string>>& t, vector<bool>& v, string cur, vector<string> val, int cnt) {
    if (cnt == v.size()) {
        if (ans.size() == 1) ans = vector<string>(val.begin(), val.end());
        return;
    }
    for (int i = 0; i < t.size(); i++) {
        if (t[i][0] == cur && !v[i]) {
            v[i] = true;
            val.push_back(t[i][1]);
            search(t, v, t[i][1], val, cnt + 1);
            val.pop_back();
            v[i] = false;
        }
    }
}

vector<string> solution(vector<vector<string>> tickets) {
    sort(tickets.begin(), tickets.end());
    vector<bool> v(tickets.size(), false);
    ans.push_back("ICN");
    search(tickets, v, "ICN", ans, 0);
    return ans;
}