import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Solution {
	static int n, ans;
	static int[] dr = {-1,-1,-1,0,0,1,1,1}, dc = {-1,0,1,-1,1,-1,0,1};
	static int[][] pair;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[1]);
			ArrayList<Integer>[] graph = new ArrayList[100];
			for (int i = 0; i < 100; i++) graph[i] = new ArrayList<Integer>();
			ans = 0;
			str = br.readLine().split(" ");
			for (int idx = 0; idx < n * 2; idx += 2) graph[Integer.parseInt(str[idx])].add(Integer.parseInt(str[idx+1]));
			Queue<Integer> q = new ArrayDeque<>();
			q.offer(0);
			while (!q.isEmpty()) {
				int cur = q.poll();
				if (cur == 99) {
					ans = 1;
					break;
				}
				for (int next: graph[cur]) q.offer(next);
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}