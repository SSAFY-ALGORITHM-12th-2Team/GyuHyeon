import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int len = Integer.parseInt(str[1]), weight = Integer.parseInt(str[2]);
		int[] truck = new int [Integer.parseInt(str[0])];
		str = br.readLine().split(" ");
		for (int i = 0; i < truck.length; i++) truck[i] = Integer.parseInt(str[i]);
		Queue<Integer> q = new ArrayDeque<Integer>();
		int i = 0, sum = 0, ans = 0;
		while (q.size() < len) q.offer(0);
		while (i < truck.length) {
			sum -= q.poll();
			if (sum + truck[i] <= weight) {
				sum += truck[i];
				q.offer(truck[i++]);
			}
			else q.offer(0);
			ans++;
		}
		while (!q.isEmpty() && sum > 0) {
			sum -= q.poll();
			ans++;
		}
		System.out.println(ans);
	}
}
