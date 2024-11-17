import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] ans = new int[id_list.length];
        Map<String, Integer> m = new HashMap<>(), idx = new HashMap<>(), dup = new HashMap<>();
        Map<String, Set<String>> rp = new HashMap<>();
        int i = 0;
        for (String id: id_list) {
            idx.put(id, i++);
            m.put(id, 0);
            rp.put(id, new HashSet<>());
        }
        
        for (String r: report) {
            if (dup.get(r) == null) {
                String[] args = r.split(" ");
                m.put(args[1], m.getOrDefault(args[1], 0) + 1);
                rp.get(args[0]).add(args[1]);
                dup.put(r, 1);
            }
        }
        
        for (String id: id_list) {
            for (String r: rp.get(id)) {
                if (m.get(r) >= k) {
                    ans[idx.get(id)]++;
                }
            }
        }
        return ans;
    }
}