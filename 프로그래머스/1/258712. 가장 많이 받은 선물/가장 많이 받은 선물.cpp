#include <string>
#include <vector>
#include <map>
#include <unordered_map>
#include <sstream>

using namespace std;

int solution(vector<string> friends, vector<string> gifts) {
    map<pair<string, string>, int> g; // 준사람, 받은사람 횟수
    unordered_map<string, int> r; // 선물 지수
    for (string gf: gifts) {
        istringstream iss(gf);
        string s1, s2;
        iss >> s1 >> s2;
        g[{s1, s2}]++; // 주고받은 횟수
        r[s1]++; // 줬으면 +
        r[s2]--; // 받았으면 -
    }
    int ans = 0, cnt;
    for (string f: friends) {
        int cnt = 0;
        for (string a: friends) {
            if (f == a) continue;
            if (g[{f, a}] > g[{a, f}] || (g[{f, a}] == g[{a, f}] && r[f] > r[a])) cnt++;
        }
        ans = max(ans, cnt);
    }
    
    return ans;
}