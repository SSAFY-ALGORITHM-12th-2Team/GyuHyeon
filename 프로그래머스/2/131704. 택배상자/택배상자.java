import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0, box = 1;
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < order.length; i++) {
        	while (box <= order[i]) s.push(box++);
        	if (s.peek() == order[i]) {
        		answer++;
        		s.pop();
        	}
        	else break;
        }
        return answer;
    }
}