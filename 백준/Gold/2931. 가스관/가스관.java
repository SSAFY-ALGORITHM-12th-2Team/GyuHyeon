import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
	static int n, m, ans;
	static Loc start, end;
	static char[][] map;
	static ArrayList<Loc> blanks;
	static int[] dr = {-1,0,1,0}, dc = {0,1,0,-1};
	static class Loc {
		int r, c;
		Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		ans = 0;
		map = new char[n][m];
		blanks = new ArrayList<Loc>();
		for (int i = 0; i < n; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = str[j].charAt(0);
				if (map[i][j] == '.') blanks.add(new Loc(i, j));
				if (map[i][j] == 'M') start = new Loc(i, j);
				if (map[i][j] == 'Z') end = new Loc(i, j);
			}
		}
		
		for (Loc blank: blanks) {
			boolean[] flag = new boolean[4];
			for (int d = 0; d < 4; d++) {
				int nr = blank.r + dr[d], nc = blank.c + dc[d];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] != '.' && map[nr][nc] != 'M' && map[nr][nc] != 'Z') {
					if (d == 0 && map[nr][nc] != '-' && map[nr][nc] != '2' && map[nr][nc] != '3') {
						flag[d] = true;
					}
					if (d == 1 && map[nr][nc] != '|' && map[nr][nc] != '1' && map[nr][nc] != '2') {
						flag[d] = true; 
					}
					if (d == 2 && map[nr][nc] != '-' && map[nr][nc] != '1' && map[nr][nc] != '4') {
						flag[d] = true;
					}
					if (d == 3 && map[nr][nc] != '|' && map[nr][nc] != '3' && map[nr][nc] != '4') {
						flag[d] = true; 
					}
				}
			}
			
			if (flag[0] && flag[1] && flag[2] && flag[3]) {
				map[blank.r][blank.c] = '+';
			}
			else if (flag[0] && flag[2]) {
				map[blank.r][blank.c] = '|';
			}
			else if (flag[1] && flag[3]) {
				map[blank.r][blank.c] = '-';
			}
			else if (flag[0] && flag[1]) {
				map[blank.r][blank.c] = '2';
			}
			else if (flag[1] && flag[2]) {
				map[blank.r][blank.c] = '1';
			}
			else if (flag[2] && flag[3]) {
				map[blank.r][blank.c] = '4';
			}
			else if (flag[3] && flag[0]) {
				map[blank.r][blank.c] = '3';
			}
			
			if (map[blank.r][blank.c] == '.') continue;
			if (search(start.r, start.c)) {
				System.out.println((blank.r + 1) + " " + (blank.c + 1) + " " + map[blank.r][blank.c]);
				return;
			}
			map[blank.r][blank.c] = '.';
		}
	}
	private static boolean search(int i, int j) {
		Queue<Loc> q = new ArrayDeque<Loc>();
		boolean[][] v = new boolean[n][m];
		v[i][j] = true;
		q.offer(new Loc(i, j));
		while (!q.isEmpty()) {
			Loc cur = q.poll();
			if (cur.r == end.r && cur.c == end.c) return true;
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d], nc = cur.c + dc[d];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && !v[nr][nc] && map[nr][nc] != '.') {
					if (d == 0 && map[nr][nc] != '-' && map[nr][nc] != '2' && map[nr][nc] != '3') {
						v[nr][nc] = true;
						q.offer(new Loc(nr, nc));
					}
					if (d == 1 && map[nr][nc] != '|' && map[nr][nc] != '1' && map[nr][nc] != '2') {
						v[nr][nc] = true;
						q.offer(new Loc(nr, nc));
					}
					if (d == 2 && map[nr][nc] != '-' && map[nr][nc] != '1' && map[nr][nc] != '4') {
						v[nr][nc] = true;
						q.offer(new Loc(nr, nc));
					}
					if (d == 3 && map[nr][nc] != '|' && map[nr][nc] != '3' && map[nr][nc] != '4') {
						v[nr][nc] = true;
						q.offer(new Loc(nr, nc));
					}
				}
			}
		}
		return false;
	}
}
