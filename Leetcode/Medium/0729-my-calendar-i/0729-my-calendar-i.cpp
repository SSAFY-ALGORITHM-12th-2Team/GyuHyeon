class MyCalendar {
public:
    set<pair<int, int>> c;

    MyCalendar() {
        c.clear();    
    }
    
    bool book(int start, int end) {
        pair<int, int> e{start, end};
        auto next = c.lower_bound(e);
        if (next != c.end() && next->first < end) return false;
        if (next != c.begin()) {
            auto pre = prev(next);
            if (pre->second > start) return false;
        }
        c.insert(e);
        return true;
    }
};

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar* obj = new MyCalendar();
 * bool param_1 = obj->book(start,end);
 */