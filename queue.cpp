//232. Implement Queue using Stacks
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// I have taken two stacks if i want the first element of the stack then, i will return the top element in out stack 
// if the out stack is empty then i will pop all the elements in the in stack and push to the out stack then get the top element
// pop opertion is also the same method as pee operation.
class MyQueue {
public:
    stack<int> in;
    stack<int> out;
    void push(int x) {
        in.push(x);
    }
    
    int pop() {
       if(out.empty())
        {
            while(!in.empty())
            {
                out.push(in.top());
                in.pop();
            }
        }
        int x = out.top();
        out.pop();
        return x;
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
        if(in.size() == 0 && out.size() == 0) return true;
        return false;
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