import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[][] j = new int[n[0]][2];
		int[] b = new int[n[1]];
		for (int i = 0; i < n[0]; i++) j[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for (int i = 0; i < n[1]; i++) b[i] = Integer.parseInt(br.readLine());
		Arrays.sort(j, Comparator.comparingInt(o -> o[0]));
		Arrays.sort(b);
		long ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0, cur = 0; i < n[1]; i++) {
		    while (cur < n[0] && j[cur][0] <= b[i]) pq.offer(j[cur++][1]);
		    if (!pq.isEmpty()) ans += pq.poll();
		}
		System.out.println(ans);
	}
}