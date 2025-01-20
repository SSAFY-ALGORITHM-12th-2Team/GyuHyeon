import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int m = Integer.parseInt(br.readLine());
		int[][] p = new int[n][n];
		for (int i = 0; i < n; i++) {
		    p[i][i] = 1; // 홀수
		    for (int j = 1; i + j < n && i - j >= 0; j++) {
		        if (arr[i-j] == arr[i+j]) p[i-j][i+j] = 1;
		        else break;
		    }
		    if (i < n - 1 && arr[i] == arr[i+1]) { // 짝수
		        p[i][i+1]= 1;
		        for (int j = 1; i + 1 + j < n && i - j >= 0; j++) {
		            if (arr[i-j] == arr[i+1+j]) p[i-j][i+1+j] = 1;
		            else break;
		        }
		    }
		}
		for (int i = 0; i < m; i++) {
		    int[] pa = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		    sb.append(p[pa[0]-1][pa[1]-1] + "\n");
		}
		System.out.println(sb);
	}
}