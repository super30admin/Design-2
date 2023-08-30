//Time complexity: Push: O(n) pop(): O(1) empty():O(1) peek:O(1)
//Space complexity: push(): OO(n) pop(): O(1) empty:O(1) peek():O(1)
class MyQueue {
public:
stack<int> in;
stack<int> out;

    MyQueue() {
        
    }
    
    void push(int x) {
        in.push(x);
    }
    
    int pop() {
        peek();
        int temp=out.top();
        out.pop();
        return temp;
    }
    
    int peek() {
        if(out.empty())
        {
            while(!in.empty())
            {   
                out.push(in.top());
                in.pop();
            }
        }
        return out.top();
    }
    
    bool empty() {
        return in.empty() and out.empty();
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