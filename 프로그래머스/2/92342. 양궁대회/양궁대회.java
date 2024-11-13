import java.util.*;

class Solution {
    int[] ans = { -1 };
    int diff = 0;
    public int[] solution(int n, int[] info) {
        int[] score = new int[11];
        gen(n, info, score, 0);
        return ans;
    }
    private void gen(int n, int[] info, int[] score, int idx) {
        if (idx == 11 || n == 0) {
            if (n == 0) {
                int p = 0, r = 0;
                for (int i = 0; i < 11; i++) {
                    if (score[i] > info[i]) r += (10 - i);
                    else if (score[i] == 0 && info[i] == 0) continue;
                    else p += (10 - i);
                }

                if (diff < (r - p)) {
                    ans = Arrays.copyOf(score, 11);
                    diff = r - p;
                } else if (diff == (r - p)) {
                    for (int i = 10; i >= 0 && ans.length == 11; i--) {
                        if (ans[i] < score[i]) {
                            ans = Arrays.copyOf(score, 11);
                            diff = r - p;
                            break;
                        }
                        else if (ans[i] > score[i]) break;
                    }
                }
            }
            return;
        }
        for (int i = 0; i <= n; i++) {
            if (n - i >= 0) {
                score[idx] = i;
                gen(n - i, info, score, idx+1);
                score[idx] = 0;
            }
            else break;
        }
    }
}