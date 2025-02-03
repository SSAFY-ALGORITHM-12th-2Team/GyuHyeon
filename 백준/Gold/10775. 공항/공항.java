import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int gates = Integer.parseInt(br.readLine()), planes = Integer.parseInt(br.readLine());
		boolean[] g = new boolean[gates + 1];
		int[] p = new int[gates + 1];
		for (int ans = 0; ans < planes; ans++) {
		    int cur = Integer.parseInt(br.readLine());
		    if (cur > gates) {
		        System.out.println(ans);
		        return;
		    }
		    if (!g[cur]) {
		        g[cur] = true;
		        p[cur] = cur;
		    }
		    else {
		        boolean flag = false;
		        if (p[cur] != 0) {
		            for (int i = p[cur] - 1; i > 0; i--) {
		                if (!g[i]) {
		                    flag = true;
		                    g[i] = true;
		                    p[cur] = i;
		                    break;
		                }
		            }
		            
		        }
		        else {
		            for (int i = cur - 1; i > 0; i--) {
		                if (!g[i]) {
		                    flag = true;
		                    g[i] = true;
		                    p[cur] = i;
		                    break;
		                }
		            }
		        }
		        if (!flag) {
		            System.out.println(ans);
		            return;
		        }
		    }
		}
		System.out.println(planes);
	}
}