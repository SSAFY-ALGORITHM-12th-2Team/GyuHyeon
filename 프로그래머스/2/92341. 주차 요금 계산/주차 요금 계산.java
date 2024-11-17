import java.util.*;

class Solution {
    private int getm(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> m = new HashMap<>(), t = new HashMap<>();
        for (String record: records) {
            String[] r = record.split(" ");
            int car = Integer.parseInt(r[1]);
            if (r[2].equals("IN")) t.put(car, getm(r[0]));
            else {
                m.put(car, m.getOrDefault(car, 0) + getm(r[0]) - t.get(car));
                t.remove(car);
            }
        }
        for (Integer car : t.keySet()) {
            m.put(car, m.getOrDefault(car, 0) + getm("23:59") - t.get(car));
        }
        int[] ans = new int[m.size()];
        int i = 0;
        List<Integer> keySet = new ArrayList<>(m.keySet());
        Collections.sort(keySet);
        for (Integer car : keySet) {
            ans[i] = fees[1];
            if (m.get(car) > fees[0]) {
                ans[i] += ((m.get(car) - fees[0]) / fees[2]) * fees[3];
                ans[i] += (((double) (m.get(car) - fees[0]) % (double) fees[2]) != 0 ? fees[3] :0);
            }
            i++;
        }
        return ans;
    }
}