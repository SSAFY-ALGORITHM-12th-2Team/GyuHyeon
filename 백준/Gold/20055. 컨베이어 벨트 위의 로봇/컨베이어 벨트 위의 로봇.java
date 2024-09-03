import java.io.*;

public class Main {
	static class Node {
		int d;
		boolean r;
		Node (int d) {
			this.d = d;
			this.r = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]), k = Integer.parseInt(str[1]), start = 0, ans = 0;
		Node[] belt = new Node[n * 2];
		str = br.readLine().split(" ");
		for (int i = 0; i < n * 2; i++) belt[i] = new Node(Integer.parseInt(str[i]));
		do {
			start = (start == 0 ? n*2-1 : start-1);
			int end = (start + n - 1 >= n * 2 ? (start + n - 1) - (n * 2) : start + n - 1);
			belt[end].r = false; // 회전하자마자 있는 로봇 내림
			int cnt = 0, i = end;
			while (cnt++ < n-1) {
				int prev = (i == 0 ? n*2-1 : i-1);
				if (belt[i].d == 0 || !belt[prev].r) {
					i = (i == 0 ? n*2-1 : i-1);
					continue;
				}
				else if (!belt[i].r && belt[prev].r) {
					belt[i].r = true;
					belt[prev].r = false;
					if (--belt[i].d == 0) k--;
				}
				i = (i == 0 ? n*2-1 : i-1);
			}
			belt[end].r = false;
			if (belt[start].d > 0) {
				belt[start].r = true;
				if (--belt[start].d == 0) k--;
			}
			ans++;
		} while (k > 0);
		System.out.println(ans);
	}
}