import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static StringBuilder sb;
	static char[] arr;
	static int v, e, v1, v2;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String[] str = br.readLine().split(" ");
			v = Integer.parseInt(str[0]);
			e = Integer.parseInt(str[1]);
			v1 = Integer.parseInt(str[2]);
			v2 = Integer.parseInt(str[3]);
			parent = new int[v+1];
			parent[1] = 1;
			str = br.readLine().split(" ");
			for (int i = 0; i < e * 2; i+=2) {
				parent[Integer.parseInt(str[i+1])] = Integer.parseInt(str[i]);
			}
			int tmp, ans = 0;
			do {
				tmp = v2;
				while (parent[tmp] != tmp) {
					if (v1 == tmp) break;
					tmp = parent[tmp];
				}
				if (v1 != tmp) v1 = parent[v1];
			} while (v1 != 1 && v1 != tmp);
			parent[v1] = v1;
			for (int i = 1; i <= v; i++) {
				parent[i] = find(parent[i]);
				if (parent[i] == v1) ans++;
			}
			System.out.println("#" + t + " " + v1 + " " + ans);
		}
	}
	static int find(int x) {
		if (x == parent[x]) return x;
		return find(parent[x]);
	}
}