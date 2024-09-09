#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int main(int argc, char** argv) {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int tc, n, num, mod = 20171109;
    cin >> tc;
    for (int t = 1; t <= tc; t++) {
        int ans = 0;
        priority_queue<int> pq;
        priority_queue<int, vector<int>, greater<int>> pq2;
        int size = 1;
        cin >> n >> num;
        pq.push(num);
        for (int i = 0; i < n; i++) {
            int val;
            cin >> val;
            pq.push(val);
            cin >> val;
            pq.push(val);
            size += 2;
            while (!pq.empty() && pq.size() > size / 2 + 1) {
                pq2.push(pq.top());
                pq.pop();
            }
            while (pq.top() > pq2.top()) {
                int tmp = pq.top();
                int tmp2 = pq2.top();
                pq.pop();
                pq2.pop();
                pq2.push(tmp);
                pq.push(tmp2);
            }
            ans = (ans + pq.top()) % mod;
        }
        cout << "#" << t << " " << ans << "\n";
    }
    return 0;
}