// Time Complexity : Amortized O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//1.Maintained 2 stacks one as in stack and other as out stack 
//2. will pop elements from out stack and all incoming elements will be in stack

#include <stack>
using namespace std;
class MyQueue {
public:
    std::stack<int> s1,s2;
    MyQueue() { 
    }
    
    void push(int x) {
        s1.push(x);
        
    }
    
    int pop() {
        
        int x = peek();
        s2.pop();  
        return x;
    }
    
    int peek() {
        if(s2.empty())
        {
            while(!s1.empty())
            {
                s2.push(s1.top());
                s1.pop();
            }
        }
        return s2.top();  
        
    }
    
    bool empty() {
        return s2.empty()&&s1.empty();
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