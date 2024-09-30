class MyCalendarTwo {
public:
    map<int, int> m;

    MyCalendarTwo() {
        m.clear();
    }
    
    bool book(int start, int end) {
        m[start]++;
        m[end]--;

        int booking = 0;
        for (pair<int, int> b: m) {
            booking += b.second;
            if (booking > 2) {
                m[start]--;
                m[end]++;

                if (m[start] == 0) m.erase(start);
                if (m[end] == 0) m.erase(end);
                return false;
            }
        }
        return true;
    }
};

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo* obj = new MyCalendarTwo();
 * bool param_1 = obj->book(start,end);
 */