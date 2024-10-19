import java.util.*;

class Solution {
    Map<Integer, List<Integer>> m;
    Map<Integer, Integer> log;
    int ans = -1;
    public int[] solution(int[][] dice) {
        m = new HashMap<>();
        log = new HashMap<>();
        int sel = 0;
        select(dice, sel, 0, 0);
        int[] ansArr = new int[dice.length / 2];
        int idx = 0;
        for (int i = 0; i < dice.length; i++) {
            if ((ans & (1 << i)) > 0) ansArr[idx++] = (i + 1);
        }
        return ansArr;
    }
    private void select(int[][] dice, int sel, int i, int k) {
        if (k == dice.length / 2) roll(dice, sel);
        else if (i == dice.length) return;
        else {
            sel |= (1 << i);
            select(dice, sel, i+1, k+1);
            sel = sel & ~(1 << i);
            select(dice, sel, i+1, k);
        }
    }
    private void roll(int[][] dice, int sel) {
        int rem = 0;
        for (int i = 0; i < dice.length; i++) if ((sel & (1 << i)) == 0) rem |= (1 << i);
        if (log.get(sel) == null) {
            List<Integer> l1 = gen(dice, sel), l2 = gen(dice, rem);
            int idx1 = 0, idx2 = 0, score = 0;
            while (idx1 < l1.size() && idx2 < l2.size()) {
                if (l1.get(idx1) > l2.get(idx2)) {
                    score++;
                    idx2++;
                }
                else {
                    score += idx2;
                    idx1++;
                }
            }
            if (idx2 == l2.size()) score += (l2.size() * (l1.size() - idx1));
            log.put(sel, score);
        }
        
        if (ans == -1 || log.get(ans) < log.get(sel)) ans = sel;
        
    }
    private List<Integer> gen(int[][] dice, int sel) {
        List<Integer> res = m.get(sel);
        if (res != null) return res;
        else res = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < dice.length; i++) {
            if ((sel & (1 << i)) > 0) {
                if (!q.isEmpty()) {
                    int size = q.size();
                    while (size-- > 0) {
                        int cur = q.poll();
                        for (int j = 0; j < 6; j++) q.offer(cur + dice[i][j]);
                    }
                } else {
                    for (int j = 0; j < 6; j++) q.offer(dice[i][j]);
                }
            }
        }
        while (!q.isEmpty()) res.add(q.poll());
        Collections.sort(res);
        m.put(sel, res);
        return res;
    }
}