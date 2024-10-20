import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int ans = 1, sum = cards.length + 1;
        Map<Integer, Integer> have = new HashMap<>(), hold = new HashMap<>();
        for (int i = 0; i < cards.length / 3; i++) have.put(cards[i], cards[i]);
        for (int i = cards.length / 3; i < cards.length; i+=2) {
            boolean flag = false;
            for (int key: have.keySet()) {
                if (have.get(sum - key) != null) {
                    have.remove(key);
                    have.remove(sum - key);
                    flag = true;
                    break;
                } else if (hold.get(sum - key) != null && coin > 0) {
                    have.remove(key);
                    hold.remove(sum - key);
                    coin--;
                    flag = true;
                    break;
                }
            }
            
            if (flag) {
                hold.put(cards[i], cards[i]);
                hold.put(cards[i+1], cards[i+1]);
                ans++;
                continue;
            }
            
            if (coin >= 1) {
                if (have.get(sum - cards[i]) != null) {
                    have.remove(sum - cards[i]);
                    hold.put(cards[i+1], cards[i+1]);
                    coin -= 1;
                    ans++;
                    continue;
                } else if (have.get(sum - cards[i+1]) != null) {
                    have.remove(sum - cards[i+1]);
                    hold.put(cards[i], cards[i]);
                    coin -= 1;
                    ans++;
                    continue;
                }
            }
                
            if (!flag && coin >= 2) {
                if (hold.get(sum - cards[i]) != null) {
                    hold.remove(sum - cards[i]);
                    hold.put(cards[i+1], cards[i+1]);
                    coin -= 2;
                    ans++;
                    continue;
                } else if (hold.get(sum - cards[i+1]) != null) {
                    hold.remove(sum - cards[i+1]);
                    hold.put(cards[i], cards[i]);
                    coin -= 2;
                    ans++;
                    continue;
                }
                    
                for (int key: hold.keySet()) {
                    if (hold.get(sum - key) != null) {
                        hold.remove(key);
                        hold.remove(sum - key);
                        coin -= 2;
                        flag = true;
                        hold.put(cards[i], cards[i]);
                        hold.put(cards[i+1], cards[i+1]);
                        break;
                    }
                }
                if (flag) {
                    ans++;
                    continue;
                }
                    
                if (cards[i] + cards[i+1] == sum) {
                    coin -= 2;
                    ans++;
                    continue;
                }
            }
            return ans;
        }
        return ans;
    }
}