import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Pot {
	int i;
	int j;
	Pot(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class Solution {
	static int[][] map;
	static int n, m, c, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			map = new int[n][n];
			m = Integer.parseInt(str[1]);
			c = Integer.parseInt(str[2]);
			ans = 0;
			ArrayList<Pot> pots = new ArrayList<Pot>();
			for (int i = 0; i < n; i++) {
				str = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(str[j]);
					pots.add(new Pot(i, j));
				}
			}
			Pot[] sel = new Pot[2];
			comb(pots, sel, 0, 0);
			
			System.out.println("#" + t + " " + ans);
		}
	}
	private static void comb(ArrayList<Pot> pots, Pot[] sel, int idx, int k) {
		if (k == 2) {
			if (sel[0].i == sel[1].i && Math.abs(sel[0].j - sel[1].j) < m) return;
			solve(sel);
			return;
		}
		if (idx == pots.size()) return;
		sel[k] = pots.get(idx);
		comb(pots, sel, idx+1, k+1);
		comb(pots, sel, idx+1, k);
	}
	static int max_prof;
	private static void solve(Pot[] sel) {
		int profit = 0;
		for (Pot pot: sel) {
			ArrayList<Integer> price = new ArrayList<Integer>();
			for (int k = 0; k < m; k++) if (pot.j + k < n) price.add(map[pot.i][pot.j + k]);
			max_prof = 0;
			comb2(price, 0, 0, 0);
			profit += max_prof;
		}
		ans = Math.max(ans, profit);
	}
	private static void comb2(ArrayList<Integer> price, int idx, int total, int prof) {
		max_prof = Math.max(max_prof, prof);
		if (idx == price.size()) {
			return;
		}
		if (total + price.get(idx) <= c) comb2(price, idx+1, total+price.get(idx), prof + price.get(idx) * price.get(idx));
		comb2(price, idx+1, total, prof);
	}
}
