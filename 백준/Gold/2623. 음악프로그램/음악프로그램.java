import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		List<Integer>[] g = new ArrayList[n[0] + 1];
		for (int i = 1; i <= n[0]; i++) g[i] = new ArrayList<Integer>();
	    int[] deg = new int[n[0] + 1];
		for (int i = 0; i < n[1]; i++) {
		    int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		    for (int j = 1; j < p.length - 1; j++) {
		        g[p[j]].add(p[j+1]);
		        deg[p[j+1]]++;
		    }
		}
		List<Integer> ans = new ArrayList<Integer>();
		Queue<Integer> q = new ArrayDeque<Integer>();
		for (int i = 1; i <= n[0]; i++) if (deg[i] == 0) q.offer(i);
		while (!q.isEmpty()) {
		    int cur = q.poll();
		    ans.add(cur);
		    for (int next: g[cur]) {
		        if (--deg[next] == 0) q.offer(next);
		    }
		}
		if (ans.size() == n[0]) for (int a: ans) System.out.println(a);
		else System.out.println(0);
	}
}