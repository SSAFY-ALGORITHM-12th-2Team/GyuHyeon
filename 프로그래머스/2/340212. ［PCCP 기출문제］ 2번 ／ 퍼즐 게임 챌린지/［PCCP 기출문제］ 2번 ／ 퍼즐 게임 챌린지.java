class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int n = diffs.length, lo = 1, hi = 100000;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            long time = 0;
            for (int i = 0; i < n; i++) {
                if (mid - diffs[i] >= 0) time += times[i];
                else {
                    if (i > 0) time += (times[i-1] * (diffs[i] - mid));
                    time += (times[i] * (diffs[i] - mid + 1));
                }
            }
            if (time <= limit) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}