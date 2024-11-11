import java.awt.Point;
import java.io.*;
import java.util.*;

public class Solution {
	static int n, ans;
	static Node[][] map;
	static class Node {
		int r, c, d, k;
		public Node(int r, int c, int d, int k) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.k = k;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			List<Node> atoms = new ArrayList<Node>();
			ans = 0;
			int[][] map = new int[4001][4001];
			for (int i = 0; i < n; i++) {
				String[] str = br.readLine().split(" ");
				map[(Integer.parseInt(str[1])+1000)*2][(Integer.parseInt(str[0])+1000)*2] = 1;
				atoms.add(new Node((Integer.parseInt(str[1])+1000)*2, (Integer.parseInt(str[0])+1000)*2, Integer.parseInt(str[2]), Integer.parseInt(str[3])));
			}
			while (!atoms.isEmpty()) {
				for (int i = 0; i < atoms.size(); i++) {
					Node atom = atoms.get(i);
					map[atom.r][atom.c]--;
					switch(atom.d) {
					case 0:
						atom.r++;
						break;
					case 1:
						atom.r--;
						break;
					case 2:
						atom.c--;
						break;
					case 3:
						atom.c++;
						break;
					}
					if (atom.r < 0 || atom.r >= 4001 || atom.c < 0 || atom.c >= 4001) {
						atoms.remove(i--);
						continue;
					}
					map[atom.r][atom.c]++;
				}
				Queue<Point> todel = new ArrayDeque<>();
				for (int i = 0; i < atoms.size(); i++) {
					if (map[atoms.get(i).r][atoms.get(i).c] > 1) {
						ans += atoms.get(i).k;
						todel.offer(new Point(atoms.get(i).r, atoms.get(i).c));
						atoms.remove(i--);
					}
				}
				while (!todel.isEmpty()) {
					Point del = todel.poll();
					map[del.x][del.y] = 0;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}