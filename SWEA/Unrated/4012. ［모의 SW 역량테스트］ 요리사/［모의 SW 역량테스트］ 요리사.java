import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
	static int[][] sng;
	static int n, roomNo, ans;
	static int[] dr = {1,-1,0,0}, dc = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			sng = new int[n][n];
			ans = Integer.MAX_VALUE;
			roomNo = 0;
			for (int i = 0; i < n; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					sng[i][j] = Integer.parseInt(str[j]);
				}
			}
			boolean[] sel = new boolean[n];
			solve(sel, 0, 0);
			System.out.println("#" + t + " " + ans);
		}
}
	private static void solve(boolean[] sel, int idx, int k) {
		if (k == n / 2) {
			ArrayList<Integer> adx = new ArrayList<Integer>(), bdx = new ArrayList<Integer>();
			int a = 0, b = 0;
			for (int i = 0; i < n; i++) {
				if (sel[i]) adx.add(i);
				else bdx.add(i);
			}
			for (int lo = 0; lo < n / 2 - 1; lo++) {
				for (int hi = lo+1; hi < n / 2; hi++) {
					a += sng[adx.get(lo)][adx.get(hi)];
					a += sng[adx.get(hi)][adx.get(lo)];
					b += sng[bdx.get(lo)][bdx.get(hi)];
					b += sng[bdx.get(hi)][bdx.get(lo)];
				}
			}
			ans = Math.min(ans, Math.abs(a - b));
			return;
		}
		if (idx == n) return;
		sel[idx] = true;
		solve(sel, idx+1, k+1);
		sel[idx] = false;
		solve(sel, idx+1, k);
	}
}