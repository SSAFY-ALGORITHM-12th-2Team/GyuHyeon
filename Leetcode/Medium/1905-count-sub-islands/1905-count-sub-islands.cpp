class Solution {
public:
    int n, m;
    int dr[4] = {1, -1, 0, 0}, dc[4] = {0, 0, 1, -1};
    void fill(vector<pair<int, int>>& island, int val, vector<vector<int>>& grid2, int i, int j) {
        grid2[i][j] = val;
        island.push_back({i, j});
        for (int d = 0; d < 4; d++) {
            int nr = i + dr[d], nc = j + dc[d];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid2[nr][nc] == 1) fill(island, val, grid2, nr, nc);
        }
    }
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        vector<vector<pair<int, int>>> islands;
        int num = 2;
        n = grid1.size();
        m = grid1[0].size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1) {
                    vector<pair<int, int>> island(0);
                    fill(island, num, grid2, i, j);
                    num++;
                    islands.push_back(island);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < islands.size(); i++) {
            bool flag = true;
            for (auto island: islands[i]) {
                if (grid1[island.first][island.second] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans++;
        }
        return ans;
    }   
};