import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static String[] str;
	static int n, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		str = new String[n];
		ans = 0;
		for (int i = 0; i < n; i++) str[i] = br.readLine();
		boolean[] v = new boolean[26];
		ArrayList<Character> alpha = new ArrayList<Character>();
		Map<Character, Integer> map = new HashMap<>();
		for (int m = 0; m < n; m++) {
			for (int i = 0; i < str[m].length(); i++) {
				if (!v[str[m].charAt(i) - 'A']) {
					v[str[m].charAt(i) - 'A'] = true;
					alpha.add(str[m].charAt(i));
				}
			}
		}
		boolean[] oc = new boolean[10];
		solve(alpha, map, 0, oc);
		System.out.println(ans);
	}
	private static void solve(ArrayList<Character> alpha, Map<Character, Integer> map, int idx, boolean[] oc) {
		if (idx == alpha.size()) {
			int sum, total = 0;
			for (int m = 0; m < n; m++) {
				sum = 0;
				for (int i = 0; i < str[m].length(); i++) {
			 		sum = sum * 10 + map.get(str[m].charAt(i));
				}
				total += sum;
			}
			ans = Math.max(ans, total);
			return;
		}
		
		for (int num = 9; num >= 0; num--) {
			if (!oc[num]) {
				oc[num] = true;
				map.put(alpha.get(idx), num);
				solve(alpha, map, idx+1, oc);
				oc[num] = false;
			}
		}
	}
}
