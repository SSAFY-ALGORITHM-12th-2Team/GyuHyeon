import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.readLine();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxA = Arrays.stream(a).max().orElse(0), maxB = Arrays.stream(b).max().orElse(0);
        int maxval = Math.max(maxA, maxB);

        List<Integer> ans = new ArrayList<>();
        for (int val = maxval; val > 0; val--) {
            while (true) {
                int ia = findIndex(a, val), ib = findIndex(b, val);
                if (ia == -1 || ib == -1) break;
                ans.add(val);
                a = Arrays.copyOfRange(a, ia + 1, a.length);
                b = Arrays.copyOfRange(b, ib + 1, b.length);
            }
        }

        System.out.println(ans.size());
        ans.forEach(x -> System.out.print(x + " "));
    }

    private static int findIndex(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) return i;
        }
        return -1;
    }
    
//     public static void main(String[] args) throws Exception {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		int n = Integer.parseInt(br.readLine());
// 		String[] arr = br.readLine().split(" ");
// 		int m = Integer.parseInt(br.readLine());
// 		String[] arr2 = br.readLine().split(" ");
// 		ArrayList<Integer>[][] dp = new ArrayList<Integer>[n+1][m+1];
// 		for (int i = 1; i <= n; i++) dp[i][0] = arr[i-1];
// 		for (int j = 1; j <= m; j++) dp[0][j] = arr2[j-1];
// 		for (int i = 1; i <= n; i++) { 
// 		    for (int j = 1; j <= m; j++) {
// 		        dp[i][j] = new ArrayList<Integer>();
// 		        if (arr[i-1].equals(arr2[j-1])) dp[i][j] = (dp[i-1][j].length() > dp[i][j-1].length() ? Arrays.copyOf(dp[i-1][j], dp[i-1][j].length()) : dp[i][j-1]) + arr[i-1];
// 		        else dp[i][j] = (dp[i-1][j].length() > dp[i][j-1].length() ? dp[i-1][j] : dp[i][j-1]);
// 		    }
// 		}
// 		String lcs = dp[n][m];
// 		int idx = 0;
// 		for (int i = 1; i < lcs.length(); i++) if (lcs.charAt(i) > lcs.charAt(idx)) idx = i;
// 		System.out.println(lcs.length() - idx);
// 		for (int i = idx; i < lcs.length(); i++) System.out.print(lcs.charAt(i) + " ");
// 	}
}