import java.util.*;

class Solution {
    private int[] ans;
    public int[] solution(int[][] edges) {
        ans = new int[4];
        // 한 정점에서 dfs bfs 할 때 모든 정점 방문이 가능하면..?;
        // 도넛: 사이클, 막대: 돌아갈 길 없음, 8: 한 정점에서 나오는 간선이 2개 이상인 노드 존재 
        ArrayList<Integer>[] g = new ArrayList[1000001];
        for (int i = 1; i <= 1000000; i++) g[i] = new ArrayList<>();
        int[] inner = new int[1000001];
        int n = 0, sum = 0;
        for (int[] e: edges) {
            inner[e[1]] = -1;
            if (inner[e[0]] == 0) inner[e[0]] = 1;
            n = Math.max(n, Math.max(e[0], e[1]));
            g[e[0]].add(e[1]);
        }
        ArrayList<Integer> vertex = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            if (inner[i] == 1 && g[i].size() > 1) {
                ans[0] = i;
                sum = g[i].size();
                for (int val: g[i]) vertex.add(val);
                g[i].clear();
                break;
            }
        }
        boolean[] visited = new boolean[n + 1];
        for (int v: vertex) search(g, v, visited);
        return ans;
    }
    
    private void search(ArrayList<Integer>[] g, int v, boolean[] visited) {
        if (g[v].size() == 0) ans[2]++;
        else if (g[v].size() == 2) ans[3]++;
        else {
            if (!visited[g[v].get(0)]) {
                visited[g[v].get(0)] = true;
                search(g, g[v].get(0), visited);
            }
            else ans[1]++;
        }
    }
}