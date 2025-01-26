import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = s.length();
		boolean[][] p = new boolean[n][n];
		for (int i = 0; i < n; i++) {
		    p[i][i] = true;
		    for (int j = 1; i + j < n && i - j >= 0; j++) {
		        if (s.charAt(i-j) == s.charAt(i+j)) p[i-j][i+j] = true;
		        else break;
		    }
		    if (i < n - 1 && s.charAt(i) == s.charAt(i+1)) {
		        p[i][i+1]= true;
		        for (int j = 1; i + 1 + j < n && i - j >= 0; j++) {
		            if (s.charAt(i-j) == s.charAt(i+1+j)) p[i-j][i+1+j] = true;
		            else break;
		        }
		    }
		}
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
		    dp[i] = dp[i-1] + 1;
		    for (int j = i - 2; j >= 0; j--) {
		        if (p[j][i - 1]) dp[i] = Math.min(dp[i], dp[j] + 1);
		    }
		}
		System.out.println(dp[n]);
	}
}