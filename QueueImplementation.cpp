#include <stack>
class MyQueue {
public:
    stack<int> pushStack;
    stack<int> popStack;
    int front;
    MyQueue() {
        front = -1;
    }
    void updatePopStack(){
    if(popStack.empty() && !pushStack.empty()){
            while(!pushStack.empty()){
                popStack.push(pushStack.top());
                pushStack.pop();
            }
        }
    }
    
    void push(int x) {
        if(pushStack.empty()){
            front =x;
        }
        pushStack.push(x);
    }
    
    int pop() {
        updatePopStack();
        if(!popStack.empty()){
             int val = popStack.top();
             popStack.pop();
             return val;
        }
        return -1;
    }
    
    int peek() {
        if(!popStack.empty()){
            return popStack.top();
        }
        else if (!pushStack.empty()){
            return front;
        }
        return -1;
        
    }
    
    bool empty() {
        if(popStack.empty() && pushStack.empty()) return true;
        else return false;
        
    }
};
