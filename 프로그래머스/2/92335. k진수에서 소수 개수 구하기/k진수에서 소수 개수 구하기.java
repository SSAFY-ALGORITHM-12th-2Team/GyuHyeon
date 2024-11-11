class Solution {
    public int solution(int n, int k) {
        int ans = 0;
        String conv = "";
        while (n > 0) {
            conv = Integer.toString(n % k) + conv;
            n /= k;
        }
        String[] nums = conv.split("0");
        for (String num: nums) {
            if (num.equals("") || num.equals("1")) continue;
            if (isPrime(Long.parseLong(num))) ans++;
        }
        return ans;
    }
    private boolean isPrime(long num) {
        for (long i = 2; i * i <= num; i++) if (num % i == 0) return false;
        return true;
    }
}