import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[][] map;
	static int n, roomNo, ans;
	static int[] dr = {1,-1,0,0}, dc = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			ans = 1;
			roomNo = 0;
			for (int i = 0; i < n; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					solve(i, j, 1, map[i][j]);
				}
			}
			System.out.println("#" + t + " " + roomNo + " " + ans);
		}
	}
	private static void solve(int i, int j, int cnt, int initRoom) {
		if (cnt > ans) {
			roomNo = initRoom;
			ans = cnt;
		}
		else if (cnt == ans) roomNo = Math.min(roomNo, initRoom);
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d], nc = j + dc[d];
			if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == map[i][j] + 1) {
				solve(nr, nc, cnt+1, initRoom);
			}
		}
	}
}
