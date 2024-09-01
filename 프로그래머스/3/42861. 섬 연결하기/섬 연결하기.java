import java.util.*;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
        });
        for (int[] cost: costs) {
            if (find(cost[0]) != find(cost[1])) {
                union(cost[0], cost[1]);
                answer += cost[2];
            }
        }
        return answer;
    }
    void union(int i, int j) {
        int x = find(i), y = find(j);
        if (x != y) parent[y] = x;
    }
    int find(int x) {
        if (x == parent[x]) return x;
        return find(parent[x]);
    }
}