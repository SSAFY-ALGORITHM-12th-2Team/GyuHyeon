import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1], score = new int[n+1];
		for (int i = 1; i <= n; i++) score[i] = Integer.parseInt(br.readLine());
		dp[1] = score[1];
		if (n > 1) dp[2] = score[1] + score[2];
		for (int i = 0; i < n; i++) {
			if (i + 2 <= n) dp[i+2] = Math.max(dp[i] + score[i+2], dp[i+2]);
			if (i + 3 <= n) dp[i+3] = Math.max(dp[i] + score[i+2] + score[i+3], dp[i+3]);
		}
		System.out.println(dp[n]);
	}
}