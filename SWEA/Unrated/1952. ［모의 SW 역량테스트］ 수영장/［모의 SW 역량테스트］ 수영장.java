import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[] fares = new int[4], months = new int[12];
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String[] str = br.readLine().split(" ");
			for (int i = 0; i < 4; i++) fares[i] = Integer.parseInt(str[i]);
			str = br.readLine().split(" ");
			for (int i = 0; i < 12; i++) months[i] = Integer.parseInt(str[i]);
			ans = fares[3];
			solve(0, 0);
			System.out.println("#" + t + " " + ans);
		}
	}
	private static void solve(int idx, int fare) {
		if (idx >= 12) {
			ans = Math.min(ans, fare);
			return;
		}
		solve(idx+1, fare + (fares[0] * months[idx]));
		solve(idx+1, fare + fares[1]);
		solve(idx+3, fare + fares[2]);
	}
}