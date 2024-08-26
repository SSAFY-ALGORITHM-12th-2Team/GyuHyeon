class Solution {
public:
    pair<int, int> calc(pair<int, int>& n1, pair<int, int>& n2, int op) {
        pair<int, int> ans;
        if (op) ans.first = (n1.first * n2.second) + (n2.first * n1.second);
        else ans.first = (n1.first * n2.second) - (n2.first * n1.second);
        ans.second = n1.second * n2.second;
        int c = gcd(ans.first, ans.second);
        ans.first /= c;
        ans.second /= c;
        if (ans.first == 0) ans.second = 1;
        return ans;
    }
    string fractionAddition(string expression) {
        int n = expression.size();
        pair<int, int> p1, p2;
        int mul = 1, op = 1, i = 0;
        while (expression[i] != '/') {
            if (expression[i] == '-') mul = -1;
            else p1.first = p1.first*10 + (expression[i] - '0');
            i++;
        }
        p1.first *= mul;
        i++;
        while (expression[i] >= '0' && expression[i] <= '9') p1.second = p1.second*10 + (expression[i++] - '0');

        while (i < n) {
            p2.first = p2.second = 0;
            if (expression[i++] == '+') op = 1;
            else op = 0;
            while (expression[i] != '/') p2.first = p2.first*10 + (expression[i++] - '0');
            i++;
            while (expression[i] >= '0' && expression[i] <= '9') p2.second = p2.second*10 + (expression[i++] - '0');
            p1 = calc(p1, p2, op);
        }
        
        return to_string(p1.first) + "/" + to_string(p1.second);
    }
};