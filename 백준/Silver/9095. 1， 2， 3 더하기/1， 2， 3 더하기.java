import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[n+1];
			if (n == 1) sb.append("1\n");
			else if (n == 2) sb.append("2\n");
			else if (n == 3) sb.append("4\n");
			else {
				dp[1] = 1;
				dp[2] = 2;
				dp[3] = 4;
				for (int i = 4; i <= n; i++) dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
				sb.append(dp[n] + "\n");
			}
		}
		System.out.println(sb);
	}
}