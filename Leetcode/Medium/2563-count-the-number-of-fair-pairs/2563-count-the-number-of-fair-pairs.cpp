class Solution {
public:
    long long countFairPairs(vector<int>& nums, int lower, int upper) {
        long long ans = 0;
        int n = nums.size();
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n-1; i++) {
            auto lo = lower_bound(nums.begin()+i+1, nums.end(), lower-nums[i]);
            auto hi = upper_bound(nums.begin()+i+1, nums.end(), upper-nums[i]);
            ans += (hi - lo);
        }
        return ans;
    }
};