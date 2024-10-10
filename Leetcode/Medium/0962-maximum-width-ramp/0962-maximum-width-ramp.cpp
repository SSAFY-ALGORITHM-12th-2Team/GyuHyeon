class Solution {
public:
    int maxWidthRamp(vector<int>& nums) {
        int n = nums.size(), lo = 0, hi = 0, ans = 0;
        vector<int> m(n);
        m[n-1] = nums[n-1];
        for (int i = n - 2; i >= 0; i--) m[i] = max(m[i+1], nums[i]);
        while (hi < n) {
            while (lo < hi && nums[lo] > m[hi]) lo++;
            ans = max(ans, hi - lo);
            hi++;
        }
        return ans;
    }
};