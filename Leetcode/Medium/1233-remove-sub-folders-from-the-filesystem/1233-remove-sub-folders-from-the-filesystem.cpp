class Solution {
    struct Trie {
        unordered_map<string, Trie*> next;
        bool isEnd = false;
    };
public:
    vector<string> removeSubfolders(vector<string>& folder) {
        sort(folder.begin(), folder.end());
        Trie* root = new Trie(), *ptr;
        vector<string> ans;
        for (auto f: folder) {
            ptr = root;
            bool flag = true;
            istringstream ss(f);
            string str;
            while (getline(ss, str, '/')) {
                if (str == "") continue;
                if (ptr->next.find(str) != ptr->next.end()) {
                    if (ptr->next[str]->isEnd) {
                        cout << str << " exists while parsing " << f << endl;
                        flag = false;
                        break;
                    }
                    else ptr = ptr->next[str];
                } else {
                    ptr->next[str] = new Trie();
                    ptr = ptr->next[str];
                }
            }
            if (flag) {
                ptr->isEnd = true;
                ans.push_back(f);
            }
        }
        return ans;
    }
};