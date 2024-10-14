import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IllegalArgumentException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]), x = Integer.parseInt(str[1]), ans = 0;
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				str = br.readLine().split(" ");
				for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(str[j]);
			}
			// 가로
			for (int i = 0; i < n; i++) {
				int h = map[i][0], cnt = 1, j = 1;
				boolean flag = true;
				while (j < n) {
					if (h == map[i][j]) cnt++;
					else {
						if (h == map[i][j] - 1 && cnt >= x) { // 올라가는 경우
							h = map[i][j];
							cnt = 1;
						}
						else if (h == map[i][j] + 1) { // 내려가는 경우
							boolean f = true;
							for (int k = j + 1; k < j + x; k++) {
								if (k >= n || map[i][j] != map[i][k]) {
									f = false;
									break;
								}
							}
							if (f) {
								h = map[i][j];
								j += x - 1;
								cnt = 0;
							} else {
								flag = false;
								break;
							}
						}
						else {
							flag = false;
							break;
						}
					}
					j++;
				}
				if (flag) ans++;
			}
			// 세로
			for (int j = 0; j < n; j++) {
				int h = map[0][j], cnt = 1, i = 1;
				boolean flag = true;
				while (i < n) {
					if (h == map[i][j]) cnt++;
					else {
						if (h == map[i][j] - 1 && cnt >= x) { // 올라가는 경우
							h = map[i][j];
							cnt = 1;
						}
						else if (h == map[i][j] + 1) { // 내려가는 경우
							boolean f = true;
							for (int k = i + 1; k < i + x; k++) {
								if (k >= n || map[i][j] != map[k][j]) {
									f = false;
									break;
								}
							}
							if (f) {
								h = map[i][j];
								i += x - 1;
								cnt = 0;
							} else {
								flag = false;
								break;
							}
						}
						else {
							flag = false;
							break;
						}
					}
					i++;
				}
				if (flag) ans++;
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
