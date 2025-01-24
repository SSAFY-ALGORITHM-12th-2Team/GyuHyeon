import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[][] l = new int[101][1], s = new int[101][1];
		
		for (int i = 0; i < n[0]; i++) {
		    int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		    l[p[0]][0] = p[1];
		}
		for (int i = 0; i < n[1]; i++) {
		    int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		    s[p[0]][0] = p[1];
		}
		int ans = 0;
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(1);
		while (!q.isEmpty()) {
		    int size = q.size();
		    while (size-- > 0) {
		        int cur = q.poll();
    		    if (cur == 100) {
    		        System.out.println(ans);
    		        return;
    		    }
    		    if (l[cur][0] != 0) q.offer(l[cur][0]);
    		    else {
    		        int idx = 1;
    		        for (int i = 1; i <= 6 && cur + i <= 100; i++) {
    		            if (l[cur + i][0] != 0) q.offer(l[cur + i][0]);
    		            if (s[cur + i][0] != 0) q.offer(s[cur + i][0]);
    		            if (l[cur + i][0] == 0 && s[cur + i][0] == 0) idx = i;
    		        }
    		        q.offer(cur + idx);
    		    }
		    }
		    ans++;
		}
	}
}