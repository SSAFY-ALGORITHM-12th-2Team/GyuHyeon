class Solution {
public:
    string compressedString(string word) {
        string ans = "";
        char cur = word[0];
        int cnt = 0;
        for (auto w: word) {
            if (w == cur) cnt++;
            else {
                ans += to_string(cnt) + cur;
                cur = w;
                cnt = 1;
            }

            if (cnt > 9) {
                ans += to_string(9) + cur;
                cnt = 1;
            }
        }
        return ans + to_string(cnt) + cur;
    }
    
};