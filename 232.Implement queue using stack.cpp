class MyQueue {
    stack<int>inst;  // to push elements
    stack<int>outst; // to pop elements

public:
    MyQueue() {}
    
    void push(int x) {
        inst.push(x);   // push to instack
    }
    
    int pop() {   //check if it outstack empty if so call peek to copy elemets from in to out and pop from outstack 
        if(empty())return -1;
        int val = peek();
        outst.pop();
        return val;
        
    }
    
    int peek() {
        if(outst.empty())
        {
          while(!inst.empty())
          {
            outst.push(inst.top());
            inst.pop();
          }
        }
         return outst.top();
    }
    
    bool empty() { //check for both stack
        return inst.empty() && outst.empty();
        
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