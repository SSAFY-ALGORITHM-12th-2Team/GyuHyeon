class Solution {
public:
    struct Node {
        bool end = false;
        Node* next[10] = { NULL, };
    };
    int longestCommonPrefix(vector<int>& arr1, vector<int>& arr2) {
        Node* head = new Node(), *ptr = head;
        int ans = 0;
        for (auto e: arr1) {
            string str = to_string(e);
            ptr = head;
            for (auto c: str) {
                if (ptr->next[c - '0'] == NULL) ptr->next[c - '0'] = new Node();
                ptr = ptr->next[c - '0'];
            }
        }
        for (auto e: arr2) {
            string str = to_string(e);
            ptr = head;
            int len = 0;
            for (auto c: str) {
                if (ptr->next[c - '0'] != NULL) {
                    ptr = ptr->next[c - '0'];
                    len++;
                } else break;
            }
            ans = max(len, ans);
        }
        return ans;
    }
};