/*
I have two stacks. Push is O(1) and pop,peek are O(2n)
*/

class MyQueue {
    stack<int> s1,s2;
public:
    MyQueue() {
        
    }
    
    void push(int x) {
        s1.push(x);
    }

    void swap(stack<int>& s, stack<int>& t) {
        while(!s.empty()) {
            t.push(s.top());
            s.pop();
        }
    }
    
    int pop() {
        swap(s1,s2);
        int ans=s2.top();
        s2.pop();
        swap(s2,s1);
        return ans;
    }
    
    int peek() {
        swap(s1,s2);
        int ans=s2.top();
        swap(s2,s1);
        return ans;
    }
    
    bool empty() {
        return s1.empty();
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */