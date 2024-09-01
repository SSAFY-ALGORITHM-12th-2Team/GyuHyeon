import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[][] map;
	static int[] dr = {1,-1,-1,1}, dc = {-1,-1,1,1};
	static boolean[][] v;
	static boolean[] d;
	static int n, ans, di, dj;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			v = new boolean[n][n];
			d = new boolean[101];
			ans = -1;
			for (int i = 0; i < n; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(str[j]);
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					v[i][j] = true;
					d[map[i][j]] = true;
					di = i;
					dj = j;
					dfs(i, j, 0, 1);
					d[map[i][j]] = false;
					v[i][j] = false;
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
	private static void dfs(int r, int c, int idx, int cnt) {
		for (int dir = idx; dir < 4; dir++) {
			int i = r + dr[dir], j = c + dc[dir];
			if (i == di && j == dj && cnt > 2) ans = Math.max(ans, cnt);
			else if (i >= 0 && i < n && j >= 0 && j < n && !v[i][j] && !d[map[i][j]]) {
				v[i][j] = true;
				d[map[i][j]] = true;
				dfs(i, j, dir, cnt+1);
				d[map[i][j]] = false;
				v[i][j] = false;
			}
		}
	}
}