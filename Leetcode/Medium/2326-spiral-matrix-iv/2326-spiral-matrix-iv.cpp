/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> spiralMatrix(int m, int n, ListNode* head) {
        vector<vector<int>> ans(m, vector<int>(n, -1));
        int cl = 0, ch = n-1, rl = 0, rh = m-1;
        while (cl <= ch && rl <= rh && head != NULL) {
            if (rl == rh && cl == ch) {
                ans[rl][cl] = head->val;
                return ans;
            }
            for (int j = cl; j < ch && head != NULL; j++) {
                ans[rl][j] = head->val;
                head = head->next;
            }
            for (int i = rl; i < rh && head != NULL; i++) {
                ans[i][ch] = head->val;
                head = head->next;
            }
            for (int j = ch; j > cl && head != NULL; j--) {
                ans[rh][j] = head->val;
                head = head->next;
            }
            for (int i = rh; i > rl && head != NULL; i--) {
                ans[i][cl] = head->val;
                head = head->next;
            }
            rl++; rh--; cl++; ch--;
        }
        return ans;
    }
};