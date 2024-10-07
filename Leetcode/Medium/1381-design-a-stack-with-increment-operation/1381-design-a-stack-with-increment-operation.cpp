class CustomStack {
public:
    int top = -1, size = 0;
    vector<int> stk;
    CustomStack(int maxSize) {
        size = maxSize;
        stk = vector<int>(maxSize, 0);
        top = -1;
    }
    
    void push(int x) {
        if (top + 1 < size) stk[++top] = x;
    }
    
    int pop() {
        int res = -1;
        if (top != -1) {
            res = stk[top];
            stk[top--] = 0;
        }
        return res;
    }
    
    void increment(int k, int val) {
        int inc = min(k, size);
        for (int i = 0; i < inc; i++) stk[i] += val;
    }
};

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack* obj = new CustomStack(maxSize);
 * obj->push(x);
 * int param_2 = obj->pop();
 * obj->increment(k,val);
 */