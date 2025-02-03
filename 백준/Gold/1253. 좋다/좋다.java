import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), ans = 0;
		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(nums);
		Map<Integer, Boolean> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
		    if (m.get(nums[i]) != null) {
		        ans++;
		        continue;
		    }
		    int lo = 0, hi = n - 1;
		    while (lo < hi) {
		        if (lo == i) lo++;
		        if (hi == i) hi--;
		        if (lo >= hi) break;
		        if (nums[lo] + nums[hi] == nums[i]) {
		            ans++;
		            m.put(nums[i], true);
		            break;
		        }
		        else if (nums[lo] + nums[hi] < nums[i]) lo++;
		        else hi--;
		    }
		}
		System.out.println(ans);
	}
}