class Solution {
public:
    vector<int> diffWaysToCompute(string expression) {
        vector<int> ans;
        if (!expression.size()) return vector<int>{};
        if ((expression.size() == 1) || (expression.size() == 2 && isdigit(expression[0]))) {
            ans.push_back(stoi(expression));
            return ans;
        }
        for (int i = 0; i < expression.size(); i++) {
            if (isdigit(expression[i])) continue;
            vector<int> left = diffWaysToCompute(expression.substr(0, i));
            vector<int> right = diffWaysToCompute(expression.substr(i+1));

            for (auto l: left) {
                for (auto r: right) {
                    switch(expression[i]) {
                        case '+':
                            ans.push_back(l + r);
                            break;
                        case '-':
                            ans.push_back(l - r);
                            break;
                        case '*':
                            ans.push_back(l * r);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return ans;
    }
};