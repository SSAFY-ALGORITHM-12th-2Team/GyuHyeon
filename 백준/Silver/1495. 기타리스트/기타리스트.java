import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]), s = Integer.parseInt(str[1]), m = Integer.parseInt(str[2]), ans = -1;
		int[] v = new int[n];
		str = br.readLine().split(" ");
		for (int i = 0; i < n; i++) v[i] = Integer.parseInt(str[i]);
		boolean[][] dp = new boolean[n+1][m+1];
		dp[0][s] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (dp[i-1][j]) {
					if (j - v[i-1] >= 0) dp[i][j-v[i-1]] = true;
					if (j + v[i-1] <= m) dp[i][j+v[i-1]] = true;
				}
			}
		}
		for (int j = 0; j <= m; j++) if (dp[n][j]) ans = j;
		System.out.println(ans);
	}
}