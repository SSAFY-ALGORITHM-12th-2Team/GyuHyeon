class Solution {
    int r = 0;
    public int[] solution(long[] numbers) {
        int[] ans = new int[numbers.length];
        int idx = 0;
        for (long num: numbers) {
            String n = Long.toBinaryString(num), d = "";
            int pow = 0;
            while (Math.pow(2, pow) - 1 < n.length()) pow++;
            for (int i = n.length(); i < Math.pow(2, pow) - 1; i++) d += "0";
            n = d + n;
            int[] arr = new int[n.length() + 1];
            r = 0;
            ans[idx++] = solve(n, arr, 1) && arr[1] == 1 ? 1 : 0;
        }
        return ans;
    }
    private boolean solve(String n, int[] arr, int idx) {
        if (idx > n.length()) return true;
        boolean f1 = solve(n, arr, idx * 2);
        arr[idx] = n.charAt(r++) == '0' ? -1 : 1;
        boolean f2 = solve(n, arr, idx * 2 + 1);
        if (arr[idx] == -1 && ((idx * 2 < arr.length && arr[idx * 2] == 1) || (idx * 2 + 1 < arr.length && arr[idx * 2 + 1] == 1))) {
            arr[idx] = 1;
            return false;
        }
        return f1 && f2;
    }
}