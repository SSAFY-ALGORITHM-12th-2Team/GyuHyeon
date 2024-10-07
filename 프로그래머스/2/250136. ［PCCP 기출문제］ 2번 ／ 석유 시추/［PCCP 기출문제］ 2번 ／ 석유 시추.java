import java.util.*;

class Solution {
    int n, m, num = 2, size;
    int[] dr = {1, 0, -1, 0}, dc = {0, 1, 0, -1};
    public void bfs(int[][] land, int i, int j) {
        size++;
        land[i][j] = num;
        for (int d = 0; d < 4; d++) {
            int nr = i + dr[d], nc = j + dc[d];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && land[nr][nc] == 1) bfs(land, nr, nc);
        }
    }
    public int solution(int[][] land) {
        int ans = 0;
        n = land.length;
        m = land[0].length;
        List<Integer> area = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1) {
                    size = 0;
                    bfs(land, i, j);
                    area.add(size);
                    num++;
                }
            }
        }
        
        for (int j = 0; j < m; j++) {
            int sum = 0;
            boolean[] v = new boolean[num-2];
            for (int i = 0; i < n; i++) {
                if (land[i][j] > 1 && !v[land[i][j] - 2]) {
                    v[land[i][j] - 2] = true;
                    sum += area.get(land[i][j] - 2);
                }
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}