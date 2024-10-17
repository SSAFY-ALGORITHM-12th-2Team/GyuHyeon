class Solution {
public:
    int maximumSwap(int num) {
        string str = to_string(num);
        int n = str.size(), sw, idx;
        for (int i = 0; i < n - 1; i++) {
            sw = str[i] - '0';
            idx = -1;
            for (int j = n - 1; j > i; j--) {
                if (sw < str[j] - '0') {
                    sw = str[j] - '0';
                    idx = j;
                }
            }
            if (sw > str[i] - '0' && idx != -1) {
                swap(str[i], str[idx]);
                return stoi(str);
            }
        }
        return stoi(str);
    }
};