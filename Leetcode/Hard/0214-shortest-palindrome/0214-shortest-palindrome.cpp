class Solution {
public:
    string shortestPalindrome(string s) {
        int n = s.size(), lo = 0;
        for (int hi = n - 1; hi >= 0; hi--) if (s[lo] == s[hi]) lo++;
        if (lo == n) return s;
        string add = s.substr(lo), radd = string(add.rbegin(), add.rend());
        // add: str not palindrome, radd: additional string
        return radd + shortestPalindrome(s.substr(0, lo)) + add;
        // s.substr(0, lo): find shortest among string not palindrome
    }
};