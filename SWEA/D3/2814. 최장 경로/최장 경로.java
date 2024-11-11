import java.io.*;
import java.util.*;

public class Solution {
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t<= T; t++) {
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);
			List<Integer>[] g = new ArrayList[n+1];
			for (int i = 1; i <= n; i++) g[i] = new ArrayList<Integer>();
			for (int i = 0; i < m; i++) {
				str = br.readLine().split(" ");
				int e1 = Integer.parseInt(str[0]), e2 = Integer.parseInt(str[1]);
				g[e1].add(e2);
				g[e2].add(e1);
			}
			ans = 1;
			for (int i = 1; i <= n; i++) {
				boolean[] v = new boolean[n+1];
				v[i] = true;
				dfs(g, v, i, 1);
			}
			System.out.println("#" + t + " " + ans);
		}
	}
	private static void dfs(List<Integer>[] g, boolean[] v, int cur, int depth) {
		ans = Math.max(ans, depth);
		for (int i = 0; i < g[cur].size(); i++) {
			if (!v[g[cur].get(i)]) {
				v[g[cur].get(i)] = true;
				dfs(g, v, g[cur].get(i), depth + 1);
                v[g[cur].get(i)] = false;
			}
		}
	}
}
