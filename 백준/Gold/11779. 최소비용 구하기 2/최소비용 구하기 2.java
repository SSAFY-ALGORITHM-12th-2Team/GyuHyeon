import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine());
		List<Point>[] g = new ArrayList[n + 1];
		long[] dist = new long[n + 1];
		Arrays.fill(dist, Long.MAX_VALUE);
		int[] prev = new int[n + 1];
        Arrays.fill(prev, -1);
		for (int i = 1; i <= n; i++) g[i] = new ArrayList<Point>();
		for (int i = 0; i < m; i++) {
		    int[] params = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		    g[params[0]].add(new Point(params[1], params[2]));
		}
		int[] c = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingLong(p -> dist[p.x]));
		List<Integer> ans = new ArrayList<Integer>(), path = new ArrayList<>();
		pq.offer(new Point(c[0], 0));
		dist[c[0]] = 0;
		while (!pq.isEmpty()) {
		    Point cur = pq.poll();
		    int v = cur.x;
		    if (cur.y > dist[v]) continue;
		    for (Point next: g[v]) {
		        if (dist[next.x] > dist[v] + next.y) {
		            dist[next.x] = dist[v] + next.y;
		            prev[next.x] = v;
		            pq.offer(new Point(next.x, (int) dist[next.x]));
		        }
		    }
		}
		for (int i = c[1]; i != -1; i = prev[i]) path.add(i);
		StringBuilder sb = new StringBuilder();
		sb.append(dist[c[1]] + "\n" + path.size() + "\n");
		for (int i = path.size() - 1; i >= 0; i--) sb.append(path.get(i) + " ");
		System.out.println(sb);
	}
}