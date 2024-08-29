import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int sum = picks[0] + picks[1] + picks[2];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < sum * 5 && i < minerals.length; i+=5) {
        	int num = 0;
        	for (int j = i; j < i + 5 && j < minerals.length; j++) {
        		switch (minerals[j]) {
        		case "diamond":
        			num += 10000;
        			break;
        		case "iron":
        			num += 100;
        			break;
        		case "stone": 
        			num += 1;
        			break;
        		}
        	}
        	pq.offer(num);
        }
        int[][] val = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        for (int p = 0; p < picks.length; p++) {
        	while (!pq.isEmpty() && picks[p]-- > 0) {
        		int cur = pq.poll();
        		for (int m = 2; m >= 0; m--) {
        			int material = cur % 100;
        			cur /= 100;
        			answer += (val[p][m] * material);
        		}
        	}
        }
        return answer;
    }
}