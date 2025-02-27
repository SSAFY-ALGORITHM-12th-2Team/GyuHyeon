class Solution {
public:
    struct cmp { 
        bool operator()(vector<int> v1, vector<int> v2) {
            if (v2[0] == v2[1]) return v1[0] > v2[0];
            return v1[1] > v2[1];
        }
    };
    int smallestChair(vector<vector<int>>& times, int targetFriend) {
        targetFriend = times[targetFriend][0];
        sort(times.begin(), times.end());
        priority_queue<vector<int>, vector<vector<int>>, cmp> oc;
        priority_queue<int, vector<int>, greater<>> chair;
        for (auto t: times) {
            while (!oc.empty() && t[0] >= oc.top()[1]) {
                chair.push(oc.top()[2]);
                oc.pop();
            }
            if (!chair.empty()) {
                t.push_back(chair.top());
                chair.pop();
            }
            else t.push_back(oc.size());
            oc.push(t);
            if (t[0] == targetFriend) return t[2];
        }
        return -1;
    }
};