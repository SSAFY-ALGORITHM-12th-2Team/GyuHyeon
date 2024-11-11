import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]), k = Integer.parseInt(str[1]);
			int[] times = new int[n+1], deg = new int[n+1], ans = new int[n+1];
			List<Integer>[] g = new ArrayList[n+1];
			str = br.readLine().split(" ");
			for (int i = 1; i <= n; i++) {
				times[i] = Integer.parseInt(str[i - 1]);
				g[i] = new ArrayList<>();
			}
			for (int i = 0; i < k; i++) {
				str = br.readLine().split(" ");
				g[Integer.parseInt(str[0])].add(Integer.parseInt(str[1]));
				deg[Integer.parseInt(str[1])]++;
			}
			int w = Integer.parseInt(br.readLine());
			Queue<Integer[]> q = new ArrayDeque<Integer[]>();
			for (int i = 1; i <= n; i++) {
				ans[i] = times[i];
				if (deg[i] == 0) q.offer(new Integer[]{i, times[i]});
			}
			while (!q.isEmpty()) {
				Integer[] cur = q.poll();
				for (int next: g[cur[0]]) {
					ans[next] = Math.max(ans[next], cur[1] + times[next]);
					if (--deg[next] == 0) q.offer(new Integer[] {next, ans[next]});
				}
			}
			bw.write(ans[w] + "\n");
		}
		br.close();
		bw.close();
	}
}