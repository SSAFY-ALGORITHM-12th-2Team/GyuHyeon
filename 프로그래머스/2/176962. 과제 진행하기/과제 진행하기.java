import java.util.PriorityQueue;
import java.util.Stack;

class Solution {
    static class Work implements Comparable<Work> {
		String name;
		int m;
		int duration;
		Work(String name, int m, int duration) {
			this.name = name;
			this.m = m;
			this.duration = duration;
		}
		@Override
		public int compareTo(Work w) {
			return this.m - w.m;
		}
	}
    public String[] solution(String[][] plans) {
        String[] ans = new String[plans.length];
        int size = 0;
        PriorityQueue<Work> pq = new PriorityQueue<Work>();
        for (String[] plan: plans) {
        	String name = plan[0];
        	int m = Integer.parseInt(plan[1].substring(0, 2)) * 60 + Integer.parseInt(plan[1].substring(3, 5));
        	int duration = Integer.parseInt(plan[2]);
        	pq.offer(new Work(name, m, duration));
        }
        Stack<Work> s = new Stack<Work>();
        
        while (!pq.isEmpty()) {
        	Work cur = pq.poll();
        	if (!pq.isEmpty()) {
        		if (pq.peek().m - cur.m >= cur.duration) {
        			ans[size++] = cur.name;
        			cur.m += cur.duration;
        			while (!s.isEmpty() && cur.m + s.peek().duration <= pq.peek().m) {
        				cur.m += s.peek().duration;
        				ans[size++] = s.pop().name;
        			}
                    if (!s.isEmpty()) s.peek().duration -= (pq.peek().m - cur.m);
        		}
        		else {
        			cur.duration -= (pq.peek().m - cur.m);
        			s.push(cur);
        		}
        	}
        	else s.push(cur);
        }
        
        while (!s.isEmpty()) ans[size++] = s.pop().name;
        
        return ans;
    }
}