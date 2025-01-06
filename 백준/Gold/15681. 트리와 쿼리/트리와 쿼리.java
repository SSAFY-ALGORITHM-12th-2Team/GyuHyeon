import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    List<Integer>[] g = new ArrayList[p[0] + 1];
    for (int i = 0; i <= p[0]; i++) g[i] = new ArrayList<Integer>();
    for (int i = 0; i < p[0] - 1; i++) {
      int[] e = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      g[e[0]].add(e[1]);
      g[e[1]].add(e[0]);
    }
    int[] subs = new int[p[0] + 1];
    boolean[] v = new boolean[p[0] + 1];
    v[p[1]] = true;
    dfs(g, subs, v, p[1]);
    StringBuilder sb = new StringBuilder();
    for (int pp = 0; pp < p[2]; pp++) {
      int q = Integer.parseInt(br.readLine());
      sb.append(subs[q] + "\n");
    }
    System.out.println(sb);
  }
  static int dfs(List<Integer>[] g, int[] subs, boolean[] v, int idx) {
    subs[idx] = 1;
    for (int next: g[idx]) {
        if (!v[next]) {
            v[next] = true;
            subs[idx] += dfs(g, subs, v, next);
            v[next] = false;
        }
    }
    return subs[idx];
  }
}