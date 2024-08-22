import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[][] map;
	static int n, income, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			map = new int[n][n];
			income = Integer.parseInt(str[1]);
			ans = 1;
			int max_cnt = 0;
			for (int i = 0; i < n; i++) {
				str = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(str[j]);
					max_cnt += map[i][j];
				}
			}
			for (int k = 2; k <= n+1; k++) {
				int expenses = k * k + (k-1)*(k-1);
				if (expenses > max_cnt * income) break;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) solve(i, j, k-1, expenses);
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
	static int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
	private static void solve(int i, int j, int k, int expenses) {
		int cnt = 0;
		for (int b = j-k; b <= j+k; b++) {
			if (b >= 0 && b < n && map[i][b] == 1) cnt++;
		}
		for (int a = 1; a <= k; a++) {
			if (i+a >= 0 && i+a < n) {
				for (int b = j-k+a; b <= j+k-a; b++) {
					if (b >= 0 && b < n && map[i+a][b] == 1) cnt++;
				}
			}
			if (i-a >= 0 && i-a < n) {
				for (int b = j-k+a; b <= j+k-a; b++) {
					if (b >= 0 && b < n && map[i-a][b] == 1) cnt++;
				}
			}
		}
		if (cnt * income - expenses >= 0) ans = Math.max(ans, cnt);
	}
}
