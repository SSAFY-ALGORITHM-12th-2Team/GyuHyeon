import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;
	static boolean[][] v;
	static int n, m, ans;
	static int[] dr = {-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		map = new char[n][m];
		v = new boolean[n][m];
		ans = 0;
		for (int i = 0; i < n; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < m; j++) map[i][j] = str[j].charAt(0);
		}
		for (int i = 0; i < n; i++) {
			solve(i, 0);
			
		}
		System.out.println(ans);
	}
	private static boolean solve(int i, int j) {
		if (j == m-1) {
			ans++;
			return true;
		}
		for (int d = 0; d < 3; d++) {
			int nr = i + dr[d];
			if (nr >= 0 && nr < n && !v[nr][j+1] && map[nr][j+1] == '.') {
				v[nr][j+1] = true;
				if (solve(nr, j+1)) return true;
			}
		}
		return false;
	}
}
