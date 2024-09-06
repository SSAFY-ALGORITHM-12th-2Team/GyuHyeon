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
    ListNode* modifiedList(vector<int>& nums, ListNode* head) {
        unordered_map<int, int> m;
        for (auto n: nums) m[n]++;
        ListNode* ans = new ListNode(0, head), *ptr = head, *prev = ans;
        while (ptr != NULL) {
            if (m.find(ptr->val) != m.end()) prev->next = ptr->next;
            else prev = ptr;
            ptr = ptr->next;
        }
        return ans->next;
    }
};