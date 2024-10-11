import java.io.*;
import java.util.*;

public class Solution {
	static int n, w, h, bricks, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			w = Integer.parseInt(str[1]);
			h = Integer.parseInt(str[2]);
			bricks = 0;
			int[][] map = new int[h][w];
			for (int i = 0; i < h; i++) {
				str = br.readLine().split(" ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(str[j]);
					if (map[i][j] != 0) bricks++;
				}
			}
			ans = bricks;
			solve(0, bricks, map);
			System.out.println("#" + t + " " + ans);
		}
	}
	static class Node {
		int i;
		int j;
		int len;
		Node (int i, int j, int len) {
			this.i = i;
			this.j = j;
			this.len = len;
		}
	}
	static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1 ,0};
	private static void solve(int ball, int rem, int[][] map) {
		if (ball == n || rem == 0) {
			ans = Math.min(ans, rem);
			return;
		}
		for (int j = 0; j < w; j++) { // 각 줄마다
			int[][] temp = new int[h][w];
			for (int i = 0; i < h; i++) temp[i] = Arrays.copyOf(map[i], w);
			int i = 0, r = rem;
			while (i < h && temp[i][j] == 0) i++; // 터뜨리는 시작점 찾아서
			if (i < h) {
				Queue<Node> q = new ArrayDeque<Node>(); // 터뜨리고
				q.offer(new Node(i, j, temp[i][j]));
				temp[i][j] = 0;
				r--;
				while (!q.isEmpty()) {
					Node cur = q.poll();
					for (int d = 0; d < 4; d++) {
						for (int l = 0; l < cur.len; l++) {
							int nr = cur.i + l * dr[d];
							int nc = cur.j + l * dc[d];
							if (nr >= 0 && nr < h && nc >= 0 && nc < w && temp[nr][nc] != 0) {
								q.offer(new Node(nr, nc, temp[nr][nc]));
								r--;
								temp[nr][nc] = 0;
							}
						}
					}
				}
				for (int j2 = 0; j2 < w; j2++) { // 내리기
					Stack<Integer> s = new Stack<Integer>();
					for (int i2 = 0; i2 < h; i2++) if (temp[i2][j2] != 0) s.push(temp[i2][j2]);
					for (int i2 = h - 1; i2 >= 0; i2--) {
						if (!s.empty()) temp[i2][j2] = s.pop();
						else temp[i2][j2] = 0;
					}
				}
				solve(ball+1, r, temp);
			}
		}
	}
}