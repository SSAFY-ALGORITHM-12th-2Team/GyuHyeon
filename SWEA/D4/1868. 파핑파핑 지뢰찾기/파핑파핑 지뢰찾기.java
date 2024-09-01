import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	static char[][] map;
	static int n, ans;
	static int[] dr = {-1,-1,-1,0,0,1,1,1}, dc = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine()), sr, sc;
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];
			ans = 0;
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			PriorityQueue<Element> pq = new PriorityQueue<Element>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '.') {
						int cnt = 0;
						for (int d = 0; d < 8; d++) {
							int nr = i + dr[d], nc = j + dc[d];
							if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == '.') {
								cnt++;
							}
							else if (nr < 0 || nr >= n || nc < 0 || nc >= n) cnt++;
						}
						pq.offer(new Element(cnt, i, j));
					}
				}
			}
			while (!pq.isEmpty()) {
				Element cur = pq.poll();
				if (map[cur.r][cur.c] == '.') {
					solve(cur.r, cur.c);
					ans++;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
	static class Element implements Comparable<Element> {
		int cnt, r, c;
		Element(int r, int c) {
			this.r = r;
			this.c = c;
		}
		Element(int cnt, int r, int c) {
			this.cnt = cnt;
			this.r = r;
			this.c = c;
		}
		@Override
		public int compareTo(Element e) {
			return e.cnt - this.cnt;
		}
	}
	private static void solve(int i, int j) {
		Queue<Element> q = new ArrayDeque<Element>();
		map[i][j] = '0';
		q.add(new Element(i, j));
		while (!q.isEmpty()) {
			Element cur = q.poll();
			int cnt = 0;
			for (int d = 0; d < 8; d++) {
				int nr = cur.r + dr[d], nc = cur.c + dc[d];
				if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == '*') {
					break;
				}
				cnt++;
			}
			if (cnt != 8) {
				map[cur.r][cur.c] = '1';
				continue;
			}
			for (int d = 0; d < 8; d++) {
				int nr = cur.r + dr[d], nc = cur.c + dc[d];
				if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == '.') {
					map[nr][nc] = '0';
					q.offer(new Element(nr, nc));
				}
			}
		}
	}
}
