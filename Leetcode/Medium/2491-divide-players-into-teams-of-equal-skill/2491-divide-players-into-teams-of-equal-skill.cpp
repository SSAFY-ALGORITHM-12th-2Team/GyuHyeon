class Solution {
public:
    long long dividePlayers(vector<int>& skill) {
        long long ans = 0;
        int sum = 0, lo = 0, hi = skill.size() - 1;
        sort(skill.begin(), skill.end());
        sum = skill[lo] + skill[hi];
        ans = skill[lo++] * skill[hi--];
        while (lo < hi) {
            if (skill[lo] + skill[hi] != sum) return -1;
            ans += (skill[lo++] * skill[hi--]);
        }
        return ans;
    }
};