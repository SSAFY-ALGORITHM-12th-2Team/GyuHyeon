import java.util.*;

class Solution {
    static Map<String, Integer> m;
    static class Menu implements Comparable<Menu> {
    	int cnt;
    	String name;
    	Menu(int cnt, String name) {
    		this.cnt = cnt;
    		this.name = name;
    	}
		@Override
		public int compareTo(Menu o) {
			return o.cnt - this.cnt;
		}
    }
    public String[] solution(String[] orders, int[] course) {
        List<String> ans = new ArrayList<>();
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        m = new TreeMap<>(comparator);
        int n = 0;
        for (String order: orders) {
        	n = Math.max(order.length(), n);
            char[] arr = new char[order.length()]; 
            for (int i = 0; i < arr.length; i++) arr[i] = order.charAt(i);
            Arrays.sort(arr);
            String o = new String(arr);
            gen(o, 0, o.length(), "");
        }
        PriorityQueue<Menu>[] pq = new PriorityQueue[n+1];
        for (int i = 2; i <= n; i++) pq[i] = new PriorityQueue<Menu>();
        for (Map.Entry<String, Integer> val : m.entrySet()) {
        	if (val.getValue() > 1) pq[val.getKey().length()].offer(new Menu(val.getValue(), val.getKey()));
        }
        try {
            for (int c = 0; c < course.length; c++) {
                if (pq[course[c]].isEmpty()) continue;
                int cnt = pq[course[c]].peek().cnt;
                while (!pq[course[c]].isEmpty() && cnt == pq[course[c]].peek().cnt) {
                    ans.add(pq[course[c]].poll().name);
                }
            }
        } catch (Exception e) {
        }
        Collections.sort(ans);
        return ans.toArray(new String[0]);
    }
    void gen(String order, int idx, int n, String val) {
        if (idx == n) {
            if (val.length() > 1) {
                if (m.get(val) == null) m.put(val, 1);
                else m.put(val, m.get(val) + 1);
            }
            return;
        }
        gen(order, idx+1, n, val + order.charAt(idx));
        gen(order, idx+1, n, val);
    }
}