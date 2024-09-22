import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);
		int[][] ch = new int[m][2];
		for (int i = 0; i < m; i++) {
			str = br.readLine().split(" ");
			ch[i][0] = Integer.parseInt(str[0]);
			ch[i][1] = Integer.parseInt(str[1]);
		}
		int[][] dp = new int[m+1][n+1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (ch[i-1][0] <= j) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - ch[i-1][0]] + ch[i-1][1]);
				else dp[i][j] = dp[i-1][j];
			}
		}
		System.out.println(dp[m][n]);
	}
}