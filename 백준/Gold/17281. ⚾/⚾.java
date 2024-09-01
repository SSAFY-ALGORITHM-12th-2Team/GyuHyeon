import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] b;
	static int[] dr = {1,-1,-1,1}, dc = {-1,-1,1,1}, sel;
	static boolean[] v;
	static int n, ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		b = new int[n][9];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < 9; j++) b[i][j] = Integer.parseInt(str[j]);
		}
		sel = new int[9];
		v = new boolean[9];
		v[3] = true;
		sel[3] = 0;
		p(1, 9);
		System.out.println(ans);
	}
	private static void p(int idx, int n) {
		if (idx == n) {
			ans = Math.max(ans, cal());
			return;
		}
		for (int i = 0; i < 9; i++) {			
			if (!v[i]) {
				v[i] = true;
				sel[i] = idx;
				p(idx+1, n);
				v[i] = false;
			}
		}
		
	}
	private static int cal() {
		int score = 0, out, idx = 0;
		for (int inn = 0; inn < n; inn++) {
			out = 0;
			boolean[] runner = new boolean[3];
			while (out < 3) {
				if (b[inn][sel[idx]] == 0) out++;
				else {
					for (int j = 2; j >= 0; j--) {
						if (runner[j]) {
							if (j + b[inn][sel[idx]] >= 3) score++;
							else runner[j + b[inn][sel[idx]]] = true;
						}
						runner[j] = false;
					}
					if (b[inn][sel[idx]] < 4) runner[b[inn][sel[idx]]-1] = true;
					else score++;
				}
				idx = (idx+1) % 9;
			}
		}
		return score;
	}
}