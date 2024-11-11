import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int n, m, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			String[] arg = br.readLine().split(" ");
			m = Integer.parseInt(arg[0]); 
			n = Integer.parseInt(arg[1]);
			if (m == 0 && n == 0) break;
			char[][] room = new char[n][m];
			int[][][][] dist = new int[n][m][n][m];
			Point init = null;
			List<Point> trash = new ArrayList<Point>();
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < m; j++) {
					room[i][j] = str.charAt(j);
					if (room[i][j] == '*') {
						trash.add(new Point(i, j));
						room[i][j] = '.';
					}
					else if (room[i][j] == 'o') {
						init = new Point(i, j);
						room[i][j] = '.';
					}
				}
			}
			if (trash.size() == 0) {
				bw.write("0\n");
				continue;
			}
			bfs(room, init, dist);
			for (int i = 0; i < trash.size(); i++) bfs(room, trash.get(i), dist);
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < trash.size(); i++) {
				boolean[] v = new boolean[trash.size()];
				v[i] = true;
				if (dist[init.x][init.y][trash.get(i).x][trash.get(i).y] == 0) {
					ans = -1;
					break;
				}
				else route(trash, dist, v, trash.get(i), dist[init.x][init.y][trash.get(i).x][trash.get(i).y], 1);
			}
			if (ans == Integer.MAX_VALUE) bw.write("-1\n");
			else bw.write(ans + "\n");
		}
		br.close();
		bw.close();
	}

	private static void route(List<Point> trash, int[][][][] dist, boolean[] v, Point cur, int len, int cnt) {
		if (ans == -1) return;
		if (cnt == trash.size()) {
			ans = Math.min(ans, len);
			return;
		}
		for (int i = 0; i < trash.size(); i++) {
			if (!v[i]) {
				v[i] = true;
				if (dist[cur.x][cur.y][trash.get(i).x][trash.get(i).y] == 0) ans = -1;
				else route(trash, dist, v, trash.get(i), len + dist[cur.x][cur.y][trash.get(i).x][trash.get(i).y], cnt + 1);
				v[i] = false;
			}
		}
	}

	static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	private static void bfs(char[][] room, Point init, int[][][][] dist) {
		char[][] cp = new char[n][m];
		for (int i = 0; i < n; i++) cp[i] = Arrays.copyOf(room[i], m);
		Queue<Point> q = new ArrayDeque<Point>();
		q.offer(init);
		cp[init.x][init.y] = 'v';
		int cnt = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Point cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int ni = cur.x + dr[d], nj = cur.y + dc[d];
					if (ni >= 0 && ni < n && nj >= 0 && nj < m && cp[ni][nj] == '.') {
						cp[ni][nj] = 'v';
						dist[init.x][init.y][ni][nj] = cnt;
						q.offer(new Point(ni, nj));
					}
				}
			}
			cnt++;
		}
	}
}