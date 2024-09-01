/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
private:
    vector<int> ans;
public:
    vector<int> postorder(Node* root) {
        if (!root) return ans;
        if (root->children.size() == 0) ans.push_back(root->val);
        else {
            for (auto next: root->children) postorder(next);
            ans.push_back(root->val);
        }
        return ans;
    }
};