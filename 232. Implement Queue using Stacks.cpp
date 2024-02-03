 /*
    Time Complexity: Amortized O(1) - n insertions/queries will take o(n) overall
    Space Complexity: O(n)

    - Always push to stack1
    - When pop/peek is called,
        - if stack2 is empty (initial case), pop each element from stack1 and push to stack2
        (stack2 now contains first come element in top position). Then take the top of    stack2.
        - if stack2 is not empty, the elements in stack1 (if any) must have come after whatever was pushed to stack2, and stack2 has first-come element in top, so just return the stack2 top element    
*/

class MyQueue {
public:
    stack<int> st1, st2;
    
    MyQueue() {
        while(!st1.empty())  st1.pop();
        while(!st2.empty())  st2.pop();
    }
    
    void push(int x) {
        st1.push(x);
    }
    
    int peek() {
      if(!st2.empty())
        return st2.top();
      
      while(!st1.empty()){
        int tmp = st1.top();
        st1.pop();
        st2.push(tmp);
      }

      return st2.top();
    }

    int pop() {
        if(!st2.empty()){
          int top = st2.top();
          st2.pop();
          return top;
        }

        while(!st1.empty()){
          int tmp = st1.top();
          st1.pop();
          st2.push(tmp);
        }

        int top = st2.top();
        st2.pop();
        return top;
    }
    
    bool empty() {
        return st1.empty() && st2.empty();
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
