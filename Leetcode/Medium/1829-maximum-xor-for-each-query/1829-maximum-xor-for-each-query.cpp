class Solution {
public:
    vector<int> getMaximumXor(vector<int>& nums, int maximumBit) {
        int n = nums.size(), k;
        vector<int> pf(n, 0), ans;
        pf[0] = nums[0];
        for (int i = 1; i < n; i++) pf[i] = pf[i-1] ^ nums[i];
        for (int i = n - 1; i >= 0; i--) {
            k = 0;
            for (int j = 0; j < maximumBit; j++) if ((pf[i] >> j) % 2 == 0) k |= (1 << j);
            ans.push_back(k);
        }
        return ans;
    }
};