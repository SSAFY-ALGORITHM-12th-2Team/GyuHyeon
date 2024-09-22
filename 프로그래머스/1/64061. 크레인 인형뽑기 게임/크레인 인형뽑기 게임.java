import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> basket = new ArrayList<Integer>();
        for (int i = 0; i < moves.length; i++) {
            int mov = moves[i]-1;
            int res;
            for (int j=0;j<board.length;j++) 
                if (board[j][mov] != 0) {
                    res = board[j][mov];
                    board[j][mov] = 0;
                    basket.add(res);
                    break;
                }        

            if(basket.size() > 1 && basket.get(basket.size()-1) == basket.get(basket.size()-2)) {
                basket.remove(basket.size()-1);
                basket.remove(basket.size()-1);
                answer += 2;
            }
        }
        return answer;
    }
}