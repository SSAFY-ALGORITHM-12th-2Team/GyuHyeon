class Solution {
public:
    int getLucky(string s, int k) {
        string nums = "";
        for (auto c: s) {
            int n = c - 'a' + 1;
            nums += to_string(n);
        }
        int ans = 0;
        for (auto n: nums) ans += (n - '0');
        if (k >= 2) {
            for (int i = 0; i < k - 1; i++) {
                int num = 0;
                while (ans > 0) {
                    num += ans % 10;
                    ans /= 10;
                }
                ans = num;
            }
        }
        return ans;
    }
};