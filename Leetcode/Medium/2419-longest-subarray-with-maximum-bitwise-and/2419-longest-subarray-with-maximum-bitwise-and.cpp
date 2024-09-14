class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int val = nums[0], cur = nums[0], len = 0, ans = 0;
        for (auto num: nums) {
            if (cur == num) len++;
            else {
                if (val < cur) {
                    val = cur;
                    ans = len;
                } else if (val == cur) ans = max(ans, len);
                cur = num;
                len = 1;
            }
        }
        if (val < cur) ans = len;
        else if (val == cur) ans = max(ans, len);
        return ans;
    }
};