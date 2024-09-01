import java.util.*;

class Solution {
    int k, n, ans = 0;
    boolean[] v;
    public int solution(int k, int[][] dungeons) {
        this.k = k;
        n = dungeons.length;
        int[] sel = new int[n];
        v = new boolean[n];
        solve(dungeons, sel, 0);
        return ans;
    }
    void solve(int[][] d, int[] sel, int idx) {
        if (idx == n) {
            // 피로도 계산
            int e = k, cnt = 0;
            for (int i = 0; i < n; i++) {
                if (d[sel[i]][0] <= e) {
                    cnt++;
                    e -= d[sel[i]][1];
                }
                else break;
            }
            ans = Math.max(ans, cnt);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                v[i] = true;
                sel[idx] = i;
                solve(d, sel, idx+1);
                v[i] = false;
            }
        }
    }
}