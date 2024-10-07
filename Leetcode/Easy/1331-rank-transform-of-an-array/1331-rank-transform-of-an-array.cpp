class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        map<int, vector<int>> rank;
        int n = arr.size();
        for (int i= 0; i < n; i++) rank[arr[i]].push_back(i);
        int r = 1;
        for (auto [k, v]: rank) {
            for (auto i: v) arr[i] = r;
            r++;
        }
        return arr;
    }
};