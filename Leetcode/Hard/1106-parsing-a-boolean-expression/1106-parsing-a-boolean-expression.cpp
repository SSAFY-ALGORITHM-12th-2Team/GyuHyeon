class Solution {
public:
    bool parseBoolExpr(string expression) {
        stack<char> op, res;
        for (auto e: expression) {
            if (e == 't' || e == 'f' || e == '(') res.push(e);
            else if (e == '!' || e == '&' || e == '|') op.push(e);
            else if (e == ')') {
                bool v = (res.top() == 't' ? true : false);
                res.pop();
                while (!res.empty()) {
                    if (res.top() == '(') {
                        res.pop();
                        break;
                    }
                    else if (op.top() == '&') v &= (res.top() == 't' ? true : false);
                    else if (op.top() == '|') v |= (res.top() == 't' ? true : false);
                    res.pop(); 
                }
                if (op.top() == '!') res.push((v ? 'f' : 't'));
                else res.push((v ? 't' : 'f'));
                op.pop();
            }
        }
        return res.top() == 't' ? true : false;
    }
};