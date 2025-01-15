import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main
{
    static int ans = 0, cnt = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[][] e = new int[p[1]][3];
		for (int i = 0; i < p[1]; i++) e[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(e, (a, b) -> Integer.compare(a[2], b[2]));
		int[] parent = new int[p[0] + 1];
		for (int i = 1; i < parent.length; i++) parent[i] = i;
		for (int i = 0; i < e.length; i++) {
		    union(Math.min(e[i][0], e[i][1]), Math.max(e[i][0], e[i][1]), parent, e[i][2]);
		    if (cnt == p[0] - 1) break;
		    for (int j = 1; j < parent.length; j++) parent[j] = find(parent[j], parent);
		}
		System.out.println(ans);
	}
	
	static void union(int x, int y, int[] parent, int cost) {
	    int px = find(x, parent), py = find(y, parent);
	    if (px != py) {
	        parent[py] = px;
	        ans += cost;
	        cnt++;
	    }
	}
	
	static int find(int x, int[] parent) {
	    if (parent[x] == x) return x;
	    else return parent[x] = find(parent[x], parent);
	}
}