import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[][] map;
	static boolean[][] v;
	static int n, m, ans;
	static int[] dr = {-1,0,1};
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		map = new String[n][m];
		v = new boolean[n][m];
		ans = 0;
		for (int i = 0; i < n; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < m; j++) map[i][j] = str[j];
		}
		for (int i = 0; i < n; i++) {
			flag = false;
			v[i][0] = true;
			solve(i, 0);
			
		}
		System.out.println(ans);
	}
	private static void solve(int i, int j) {
		if (j == m-1) {
			ans++;
			flag = true;
			return;
		}
		for (int d = 0; d < 3 && !flag; d++) {
			int nr = i + dr[d];
			if (nr >= 0 && nr < n && !v[nr][j+1] && map[nr][j+1].equals(".")) {
				v[nr][j+1] = true;
				solve(nr, j+1);
			}
		}
	}
}
