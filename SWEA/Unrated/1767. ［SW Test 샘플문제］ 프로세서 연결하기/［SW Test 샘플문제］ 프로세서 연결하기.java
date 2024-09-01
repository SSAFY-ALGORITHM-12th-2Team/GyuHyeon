import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    static int n, con, ans;
    static int[] dr = {1,0,-1,0}, dc = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            ArrayList<Node> p = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(str[j]);
                    if (i != 0 && i != n-1 && j != 0 && j != n-1 && arr[i][j] == 1) p.add(new Node(i, j));
                }
            }
            con = 0;
            ans = Integer.MAX_VALUE;
            dfs(p, arr, 0, 0, 0);
            
            System.out.println("#" + t + " " + ans);
        }
    }
    static class Node {
        int i;
        int j;
        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    static void dfs(ArrayList<Node> p, int[][] map, int idx, int cnt, int sum) {
        if (cnt > con) {
            con = cnt;
            ans = sum;
        } else if (cnt == con) ans = Math.min(ans, sum);
        if (idx == p.size()) return;
        for (int d = 0; d < 4; d++) {
            int nr = p.get(idx).i + dr[d], nc = p.get(idx).j + dc[d], len = 0;
            boolean flag = false;
            while (map[nr][nc] == 0) {
                len++;
                map[nr][nc] = 2;
                nr += dr[d];
                nc += dc[d];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    flag = true;
                    break;
                }
            }
            if (flag) dfs(p, map, idx+1, cnt+1, sum + len);
            nr = p.get(idx).i + dr[d];
            nc = p.get(idx).j + dc[d];
            for (int j = 0; j < len; j++) {
                if (map[nr][nc] == 2) map[nr][nc] = 0;
                else if (map[nr][nc] == 1) break;
                nr += dr[d];
                nc += dc[d];
            }
        }
        dfs(p, map, idx+1, cnt, sum);
    }
}