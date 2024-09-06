#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main(int argc, char** argv) {
    int tc;
    cin >> tc;
    for (int t = 1; t <= tc; t++) {
        int n, k;
        cin >> n >> k;
        vector<pair<int, int>> w(n);
        for (int i = 0; i < n; i++) {
            int v, c;
            cin >> v >> c;
            w[i] = {v, c};
        }
        vector<vector<int>> dp(n+1, vector<int>(k+1, 0));
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= w[i-1].first) dp[i][j] = max(dp[i-1][j-w[i-1].first] + w[i-1].second, dp[i-1][j]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        cout << "#" << t << " " << dp[n][k] << "\n";
    }
    return 0;
}