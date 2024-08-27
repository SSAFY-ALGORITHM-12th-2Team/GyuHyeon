import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	static int[][] map, dist;
	static int[] dr = {-1,0,1,0}, dc = {0,1,0,-1};
	static int n, p = 1, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		while (n != 0) {
			map = new int[n][n];
			dist = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(str[j]);
			}
			ans = Integer.MAX_VALUE;
			PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
			pq.offer(new Vertex(0, 0, map[0][0]));
			dist[0][0] = map[0][0];
			while (!pq.isEmpty()) {
				Vertex cur = pq.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cur.i + dr[d], nc = cur.j + dc[d];
					if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] > dist[cur.i][cur.j] + map[nr][nc]) {
						pq.add(new Vertex(nr, nc, cur.w + map[nr][nc]));
						dist[nr][nc] = dist[cur.i][cur.j] + map[nr][nc];
					}
				}
			}
			System.out.println("Problem " + p + ": " + dist[n-1][n-1]);
			n = Integer.parseInt(br.readLine());
			p++;
		}
	}
	static class Vertex implements Comparable<Vertex> {
		int i;
		int j;
		int w;
		Vertex(int i, int j, int w) {
			this.i = i;
			this.j = j;
			this.w = w;
		}
		@Override
		public int compareTo(Vertex v) {
			return this.w - v.w;
		}
	}
}