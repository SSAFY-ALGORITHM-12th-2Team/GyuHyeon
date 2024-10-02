import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution
{
    static class E {
        int root = 0;
        int[] elements = new int[8];
    }
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int k = Integer.parseInt(br.readLine());
			E[] ns = new E[4];
			for (int i = 0; i < 4; i++) {
				String[] str = br.readLine().split(" ");
				ns[i] = new E();
				ns[i].root = 0;
				ns[i].elements = new int[8];
				for (int j = 0; j < 8; j++) ns[i].elements[j] = Integer.parseInt(str[j]);
			}
			for (int nk = 0; nk < k; nk++) {
				String[] cmd = br.readLine().split(" ");
				rotate(ns, Integer.parseInt(cmd[0])-1, Integer.parseInt(cmd[1]), 10);
			}
			int ans = 0;
			for (int i = 0; i < 4; i++) {
				if (ns[i].elements[ns[i].root] == 1) {
					ans += Math.pow(2, i);
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
    private static void rotate(E[] ns, int cur, int dir, int prev) {
		// left
		if (cur > 0 && cur - 1 != prev) {
			int curl = (ns[cur].root - 2 < 0 ? ns[cur].root - 2 + 8 : ns[cur].root - 2);
			int prer = (ns[cur-1].root + 2 >= 8 ? ns[cur-1].root + 2 - 8 : ns[cur-1].root + 2);
			if (ns[cur].elements[curl] != ns[cur-1].elements[prer]) rotate(ns, cur - 1, dir * -1, cur); 
		}
		
		// right
		if (cur < 3 && cur + 1 != prev) {
			int curr = (ns[cur].root + 2 >= 8 ? ns[cur].root + 2 - 8 : ns[cur].root + 2);
			int nexl = (ns[cur+1].root - 2 < 0 ? ns[cur+1].root - 2 + 8 : ns[cur+1].root - 2);
			if (ns[cur].elements[curr] != ns[cur+1].elements[nexl]) rotate(ns, cur + 1, dir * -1, cur); 
		}
			
		ns[cur].root += (dir * -1);
		if (ns[cur].root < 0) ns[cur].root += 8;
		else if (ns[cur].root >= 8) ns[cur].root -= 8;
	}
}