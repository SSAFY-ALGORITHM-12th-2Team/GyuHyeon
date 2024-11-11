class Solution {
public:
    int calculate(string s) {
        s = "(" + s + ")";
        stack<string> stk;
        bool flag = false;
        int ans = 0;
        string val = "";
        for (auto c: s) {
            if (c >= '0' && c <= '9') {
                val += c;
                continue;
            }
            else {
                if (val != "") stk.push(val);
                val = "";
            }

            if (c == ' ') continue;
            else if (c == '(' || c == '+' || c == '-') {
                string op = "";
                op += c;
                stk.push(op);
            }
            else if (c == ')') {
                int val2 = stoi(stk.top());
                stk.pop();
                while (stk.top() != "(") {
                    if (stk.top() == "-") val2 *= -1;
                    stk.pop();
                    int val1 = stoi(stk.top());
                    stk.pop();
                    if (!stk.empty() && stk.top() == "-") {
                        val1 *= -1;
                        stk.pop();
                        stk.push("+");
                    }
                    val2 = val1 + val2;
                }
                stk.pop();
                stk.push(to_string(val2));
            }
        }
        return ans = stoi(stk.top());
    }
};