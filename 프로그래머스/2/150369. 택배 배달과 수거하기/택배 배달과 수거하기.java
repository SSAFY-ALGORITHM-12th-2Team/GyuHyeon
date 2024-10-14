class Solution {
    private void calc(int cap, int[] t, int idx) {
        while (idx >= 0) {
            if (cap >= t[idx]) {
                cap -= t[idx];
                t[idx] = 0;
                idx--;
            } else {
                t[idx] -= cap;
                break;
            }
        }
    }
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long ans = 0;
        int i = n - 1;
        while (i >= 0) {
            if (deliveries[i] == 0 && pickups[i] == 0) {
                i--;
                continue;
            }
            calc(cap, deliveries, i);
            calc(cap, pickups, i);
            
            ans += ((i + 1) * 2);
        }
        return ans;
    }
}