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
    TreeNode* replaceValueInTree(TreeNode* root) {
        queue<TreeNode*> q;
        q.push(root);
        vector<int> sum;
        int depth = 0, size;
        while (!q.empty()) {
            size = q.size();
            sum.push_back(0);
            while (size--) {
                sum[depth] += q.front()->val;
                if (q.front()->left) q.push(q.front()->left);
                if (q.front()->right) q.push(q.front()->right);
                q.pop();
            }
            depth++;
        }
        sum.push_back(0);

        root->val = 0;
        depth = 0;
        q.push(root);
        while (!q.empty()) {
            size = q.size();
            while (size--) {
                int val = sum[depth+1];
                if (q.front()->left) val -= q.front()->left->val;
                if (q.front()->right) val -= q.front()->right->val;
                if (q.front()->left) {
                    q.push(q.front()->left);
                    q.front()->left->val = val;
                }
                if (q.front()->right) {
                    q.push(q.front()->right);
                    q.front()->right->val = val;
                }
                q.pop();
            }
            depth++;
        }
        return root;
    }
};