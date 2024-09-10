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
    ListNode* insertGreatestCommonDivisors(ListNode* head) {
        ListNode* ptr = head;
        while (ptr->next != NULL) {
            ListNode* node = new ListNode(gcd(ptr->val, ptr->next->val), ptr->next);
            ptr->next = node;
            ptr = node->next;
        }
        return head;
    }
};