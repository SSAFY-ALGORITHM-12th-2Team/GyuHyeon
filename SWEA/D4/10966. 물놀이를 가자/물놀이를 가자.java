import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
	static int n, m;
	static int[] dr = {0,1,0,-1}, dc = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			m = Integer.parseInt(str[1]);
			int[][] mem = new int[n][m];
			boolean[][] v = new boolean[n][m];
			Queue<int[]> q = new ArrayDeque<int[]>();
			for (int i = 0; i < n; i++) {
				Arrays.fill(mem[i], Integer.MAX_VALUE);
				str = br.readLine().split("");
				for (int j = 0; j < m; j++) {
					if (str[j].equals("W")) {
						mem[i][j] = 0;
						v[i][j] = true;
						int[] loc = {i, j};
						q.add(loc);
					}
				}
			}
			int ans = 0;
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d], nc = cur[1] + dc[d];
					if (nr >= 0 && nr < n && nc >= 0 && nc < m && !v[nr][nc] && mem[nr][nc] > mem[cur[0]][cur[1]] + 1) {
						v[nr][nc] = true;
						mem[nr][nc] = mem[cur[0]][cur[1]]+1;
						ans += mem[nr][nc];
						int[] next = {nr, nc};
						q.offer(next);
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}