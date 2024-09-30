class Solution {
public:
    struct Trie {
        int count = 0;
        Trie* next[26] = {};
    };
    vector<int> sumPrefixScores(vector<string>& words) {
        Trie* head = new Trie(), *ptr;
        for (auto word: words) {
            ptr = head;
            for (auto c: word) {
                if (!ptr->next[c - 'a']) ptr->next[c - 'a'] = new Trie();
                ptr->next[c - 'a']->count++;
                ptr = ptr->next[c - 'a'];
            }
        }
        vector<int> ans;
        for (auto word: words) {
            int val = 0;
            ptr = head;
            for (auto c: word) {
                val += ptr->next[c - 'a']->count;
                ptr = ptr->next[c - 'a'];
            }
            ans.push_back(val);
        }
        return ans;
    }
};