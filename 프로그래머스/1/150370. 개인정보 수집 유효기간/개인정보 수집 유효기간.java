import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        int idx = 1;
        Map<Character, Integer> m = new HashMap<>();
        for (String t: terms) m.put(t.charAt(0), Integer.parseInt(t.substring(2)));
        for (String p: privacies) {
            if (calc(p.substring(0, p.length() - 2), m.get(p.charAt(p.length() - 1)), today)) answer.add(idx);
            idx++;
        }
        int[] ans = new int[answer.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = answer.get(i);
        return ans;
    }
    
    private boolean calc(String cur, int duration, String today) {
        String[] date = cur.split("\\.");
        String[] now = today.split("\\.");
        int year = 0, month = Integer.parseInt(date[1]) + duration;
        if (month > 12) {
            year = month / 12;
            month %= 12;
            if (month == 0) {
                year -= 1;
                month = 12;
            }
        }
        if (year != 0) year += Integer.parseInt(date[0]);
        else year = Integer.parseInt(date[0]);
        int end = year * 10000 + month * 100 + Integer.parseInt(date[2]);
        int td = Integer.parseInt(now[0]) * 10000 + Integer.parseInt(now[1]) * 100 + Integer.parseInt(now[2]);
        return end <= td;
    }
}