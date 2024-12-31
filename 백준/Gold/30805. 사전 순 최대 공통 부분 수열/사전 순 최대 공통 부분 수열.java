import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.readLine();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxA = Arrays.stream(a).max().orElse(0), maxB = Arrays.stream(b).max().orElse(0);
        int maxval = Math.max(maxA, maxB); // 전체 배열 내 최댓값 찾기

        List<Integer> ans = new ArrayList<>();
        for (int val = maxval; val > 0; val--) { // 최댓값부터 체크
            while (true) {
                int ia = findIndex(a, val), ib = findIndex(b, val);
                if (ia == -1 || ib == -1) break;
                ans.add(val);
                a = Arrays.copyOfRange(a, ia + 1, a.length); // 최댓값 있는 자리부터 뒤쪽까지 복사
                b = Arrays.copyOfRange(b, ib + 1, b.length); // 최댓값보다 앞쪽의 값은 알 필요 없음
            }
        }
        System.out.println(ans.size());
        ans.forEach(x -> System.out.print(x + " "));
    }
    private static int findIndex(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) return i;
        }
        return -1;
    }
}