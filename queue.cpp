// Time complexity:
// Push operation is O(n)
// Pop operation is O(1)
// 
// Space complexity is O(n)

class MyQueue {
private:
    std::stack<int> primary;
    std::stack<int> secondary;

public:
    MyQueue() {
        
    }
    
    void push(int x) {
        while (!primary.empty()) {
            int top = primary.top();
            secondary.push(top);
            primary.pop();
        }

        primary.push(x);

        while (!secondary.empty()) {
            int top = secondary.top();
            primary.push(top);
            secondary.pop();
        }
    }
    
    int pop() {
        int top = primary.top();
        primary.pop();
        return top;
    }
    
    int peek() {
        return primary.top();
    }
    
    bool empty() {
        return primary.empty();
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