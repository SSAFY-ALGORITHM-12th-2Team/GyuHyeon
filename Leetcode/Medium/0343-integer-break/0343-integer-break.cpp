class Solution {
public:
    int integerBreak(int n) {
        if (n == 2) return 1;
        else if (n == 3) return 2;
        int a2 = 0, a3 = 0;
        while (n % 3 != 0) {
            a2++;
            n -= 2;
        }
        a3 = n / 3;
        return pow(2, a2) * pow(3, a3);
    }
};