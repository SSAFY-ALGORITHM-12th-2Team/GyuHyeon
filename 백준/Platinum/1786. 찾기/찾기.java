import java.io.*;
import java.util.*;

public class Main {
	static int cnt = 0;
	static List<Integer> loc;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String t = br.readLine(), p = br.readLine();
		int[] f = new int[p.length()];
		loc = new ArrayList<>();
		func(f, p);
		kmp(f, t, p);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(cnt + "\n");
		for (int i = 0; i < loc.size(); i++) bw.write(loc.get(i) + " ");
		bw.close();
		br.close();
	}

	private static void func(int[] f, String p) {
		int i = 1, j = 0;
		while (i < p.length()) {
			if (p.charAt(i) == p.charAt(j)) {
				f[i] = j + 1;
				i++;
				j++;
			}
			else if (j > 0) j = f[j - 1];
			else {
				f[j] = 0;
				i++;
			}
		}
	}

	private static void kmp(int[] f, String t, String p) {
		int i = 0, j = 0;
		while (i < t.length()) {
			if (t.charAt(i) == p.charAt(j)) {
				if (j == p.length() - 1) {
					cnt++;
					loc.add(i - j + 1);
					i++;
					j = f[j];
				}
				else {
					i++;
					j++;
				}
			}
			else {
				if (j > 0) j = f[j - 1];
				else i++;
			}
		}
	}
}