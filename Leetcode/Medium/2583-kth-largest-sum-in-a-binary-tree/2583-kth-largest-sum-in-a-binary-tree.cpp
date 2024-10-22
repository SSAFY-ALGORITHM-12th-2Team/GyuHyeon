/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    long long kthLargestLevelSum(TreeNode* root, int k) {
        queue<TreeNode*> q;
        vector<long long> ans;
        q.push(root);
        while(!q.empty()) {
            int size = q.size();
            long long sum = 0;
            while (size--) {
                sum += q.front()->val;
                if (q.front()->left != NULL) q.push(q.front()->left);
                if (q.front()->right != NULL) q.push(q.front()->right);
                q.pop();
            }
            ans.push_back(sum);
        }
        sort(ans.begin(), ans.end());
        return (ans.size() < k) ? -1 : ans[ans.size() - k];
    }
};