class Solution {
    private boolean cmp(String s1, String s2) { // return s1 < s2;
        int i1 = Integer.parseInt(s1.substring(0, 2)) * 100 + Integer.parseInt(s1.substring(3, 5));
        int i2 = Integer.parseInt(s2.substring(0, 2)) * 100 + Integer.parseInt(s2.substring(3, 5));
        return i1 <= i2;
    }
    private String convert(String cur, int op, String len) {
        int m = Integer.parseInt(cur.substring(0, 2)), s = Integer.parseInt(cur.substring(3, 5)) + op;
        if (s >= 60) {
            m++;
            s -= 60;
        }
        else if (s < 0) {
            m--;
            s += 60;
        }
        if (m < 0) return "00:00";
        else if (Integer.parseInt(len.substring(0, 2)) * 100 + Integer.parseInt(len.substring(3, 5)) < m * 100 + s) return len;
        return (m < 10 ? "0" : "") + Integer.toString(m) + ":" + (s < 10 ? "0" : "") + Integer.toString(s);
    }
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String ans = pos;
        for (String c: commands) {
            if (cmp(op_start, ans) && cmp(ans, op_end)) ans = op_end;
            if (c.equals("prev")) ans = convert(ans, -10, video_len);
            if (c.equals("next")) ans = convert(ans, 10, video_len);
        }
        return (cmp(op_start, ans) && cmp(ans, op_end)) ? op_end : ans;
    }
}