import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		ArrayList<Integer>[] g = new ArrayList[n+1];
		int[] deg = new int[n+1];
		for (int i = 1; i <= n; i++) g[i] = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			str = br.readLine().split(" ");
			g[Integer.parseInt(str[0])].add(Integer.parseInt(str[1]));
			deg[Integer.parseInt(str[1])]++;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) if (deg[i] == 0) q.add(i);
		while (!q.isEmpty()) {
			int cur = q.poll();
			ans.add(cur);
			for (int i = 0; i < g[cur].size(); i++) {
				int tmp = g[cur].get(i);
				deg[tmp]--;
				if (deg[tmp] == 0) q.add(tmp);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i: ans) sb.append(i + " ");
		System.out.println(sb);
	}
}
