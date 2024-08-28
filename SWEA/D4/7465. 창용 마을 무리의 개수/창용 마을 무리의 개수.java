import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int n, m, ans;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			m = Integer.parseInt(str[1]);
			parents = new int[n+1];
			for (int i = 1; i <= n; i++) parents[i] = i;
			ans = 0;
			for (int i = 0; i < m; i++) {
				str = br.readLine().split(" ");
				union(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
			}
			
			boolean[] p = new boolean[n+1];
			for (int i = 1; i <= n; i++) {
				parents[i] = find(parents[i]);
				if (!p[parents[i]]) {
					p[parents[i]] = true;
					ans++;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
	static void union(int i, int j) {
		int x = find(i);
		int y = find(j);
		if (x != y) parents[y] = x;
	}
	private static int find(int x) {
		if (parents[x] == x) return x;
		else return find(parents[x]);
	}
}
