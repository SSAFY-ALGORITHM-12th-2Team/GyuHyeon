#include <iostream>
#include <queue>

using namespace std;

int main(int argc, char** argv) {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int tc, n;
    cin >> tc;
    for (int t = 1; t <= tc; t++) {
        cin >> n;
        priority_queue<int> pq;
        cout << "#" << t << " ";
        for (int i = 0; i < n; i++) {
            int cmd, val;
            cin >> cmd;
            if (cmd == 1) {
                cin >> val;
                pq.push(val);
            }
            else if (!pq.empty()) {
                cout << pq.top() << " ";
                pq.pop();
            } else cout << -1 << " ";
        }
        cout << "\n";
    }
    return 0;
}