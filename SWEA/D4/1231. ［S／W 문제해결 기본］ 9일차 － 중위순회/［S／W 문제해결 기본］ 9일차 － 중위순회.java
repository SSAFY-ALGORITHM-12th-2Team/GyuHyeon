import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static StringBuilder sb;
	static char[] arr;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new char[n+1];
			for (int i = 1; i <= n; i++) {
				arr[i] = br.readLine().split(" ")[1].charAt(0);
			}
			sb = new StringBuilder();
			gen(1);
			System.out.println("#" + t + " " + sb);
		}
	}

	private static void gen(int idx) {
		if (idx > n) return;
		gen(2*idx);
		sb.append(arr[idx]);
		gen(2*idx+1);
	}
}