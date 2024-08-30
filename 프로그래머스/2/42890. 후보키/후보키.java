import java.util.*;

class Solution {
    Map<String, Integer> oc;
    int n, m, len, ans = 0;
    public int solution(String[][] relation) {
        n = relation.length;
        m = relation[0].length;
        oc = new HashMap<>();
        for (int len = 1; len <= m; len++) {
            int[] sel = new int[len];
            comb(relation, 0, sel, 0, len);
        }
        return ans;
    }
    void comb(String[][] r, int idx, int[] sel, int k, int len) {
        if (k == len) {
            Map<String, Integer> mp = new HashMap<>();
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int j = 0; j < len; j++) str += (r[i][sel[j]] + ", ");
                if (mp.get(str) == null) cnt++;
                mp.put(str, 1);
            }
            ArrayList<Integer> arr = new ArrayList<>();
            if (cnt == n && minimal(arr, sel, 0)) { 
                ans++;
                oc.put(Arrays.toString(sel), 1);
            }
            return;
        }
        if (idx == m) return;
        sel[k] = idx;
        comb(r, idx+1, sel, k+1, len);
        comb(r, idx+1, sel, k, len);
    }
    boolean minimal(ArrayList<Integer> arr, int[] sel, int idx) {
        if (idx == sel.length) {
            if (oc.get(arr.toString()) != null) return false;
            else return true;
        }
        arr.add(sel[idx]);
        boolean val1 = minimal(arr, sel, idx+1);
        arr.remove(arr.size() - 1);
        boolean val2 = minimal(arr, sel, idx+1);
        return val1 && val2;
    }
}