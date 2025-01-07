import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main
{
    static int leaf = 0, ans = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Point>[] g = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) g[i] = new ArrayList<Point>();
		for (int i = 0; i < n; i++) {
		    int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		    for (int j = 1; j < p.length - 1; j += 2) g[p[0]].add(new Point(p[j], p[j+1]));
		}
		boolean[] v = new boolean[n+1];
		v[1] = true;
		dfs(g, v, 1, 0);
		v = new boolean[n+1];
		v[leaf] = true;
		dfs(g, v, leaf, 0);
		System.out.println(ans);
	}
	static void dfs(List<Point>[] g, boolean[] v, int idx, int dist) {
	    if (dist > ans) {
	        leaf = idx;
	        ans = dist;
	    }
	    for (Point next: g[idx]) {
	        if (!v[next.x]) {
	            v[next.x] = true;
	            dfs(g, v, next.x, dist + next.y);
	        }
	    }
	}
}