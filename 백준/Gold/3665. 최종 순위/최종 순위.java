import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer>[] g = new ArrayList[n+1];
			int[] deg = new int[n+1];
			int[] rank = new int[n];
			String[] str = br.readLine().split(" ");
			for (int i = 1; i <= n; i++) g[i] = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) rank[i] = Integer.parseInt(str[i]);
			for (int i = 0; i < n-1; i++) {
				for (int j = i+1; j < n; j++) {
					g[rank[i]].add(rank[j]);
					deg[rank[j]]++;
				}
			}
			int m = Integer.parseInt(br.readLine());
			for (int i = 0; i < m; i++) {
				str = br.readLine().split(" ");
				int h = Integer.parseInt(str[0]), l = Integer.parseInt(str[1]);
				if (g[l].indexOf(h) == -1) {
					int tmp = h;
					h = l;
					l = tmp;
				}
				g[h].add(l);
				g[l].remove(g[l].indexOf(h));
				deg[l]++;
				deg[h]--;
			}
			ArrayList<Integer> ans = new ArrayList<Integer>();
			Queue<Integer> q = new ArrayDeque<Integer>();
			for (int i = 1; i <= n; i++) if (deg[i] == 0) q.offer(i);
			while (!q.isEmpty()) {
				int cur = q.poll();
				ans.add(cur);
				for (int next: g[cur]) {
					if (--deg[next] == 0) q.offer(next);
				}
			}
			if (ans.size() != n) sb.append("IMPOSSIBLE\n");
			else {
				for (int i = 0; i < ans.size(); i++) sb.append(ans.get(i) + " ");
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}