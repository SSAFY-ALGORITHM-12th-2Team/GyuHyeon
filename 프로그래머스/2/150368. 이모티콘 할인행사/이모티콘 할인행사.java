class Solution {
    int[] ans;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] discounts = new int[emoticons.length];
        ans = new int[2];
        permutations(discounts, 0, users, emoticons);
        return ans;
    }
    private void permutations(int[] discounts, int idx, int[][] users, int[] emoticons) {
        if (idx == discounts.length) {
            calc(users, emoticons, discounts);
            return;
        }
        for (int i = 1; i <= 4; i++) {
            discounts[idx] = i * 10;
            permutations(discounts, idx+1, users, emoticons);
        }
    }
    private void calc(int[][] users, int[] emoticons, int[] discounts) {
        int[] cost = new int[users.length];
        for (int i = 0; i < emoticons.length; i++) {
            int price = emoticons[i] * (100 - discounts[i]) / 100;
            for (int j = 0; j < users.length; j++) {
                if (users[j][0] <= discounts[i]) cost[j] += price;
            }
        }
        int reg = 0, prof = 0;
        for (int i = 0; i < cost.length; i++) {
            if (cost[i] >= users[i][1]) reg++;
            else prof += cost[i];
        }
        if (reg > ans[0]) {
            ans[0] = reg;
            ans[1] = prof;
        } else if (reg == ans[0]) ans[1] = Math.max(ans[1], prof);
    }
}