/**
// Time Complexity :
1. Method push() : O(1) - Explanation - Just adding an integer to the top of the stack st in out class. 
2. Method pop() : O(n) - Explanation - n = number of integers currently in stack. Since queue is data structure which follows the pattern of First-In-First-Out for adding and removal of elements into it. We use a temporary stack to pop all the elements from the original stack into the temporary stack to get the first entered element on the top of the temporary stack. Store it a variable we want to return, and store back all elements from the temporary stack -> back to the original stack. Since we are accessing all the elements present in the stack it's O(n)
3. Method peek() : O(n) - Explanation - This is similar to the above implementation, but here we don't pop the last element which was transferred from the main to the temporary stack since we just want to peek / return the first-in element from the queue we are implementing. 
4. Method empty() : O(1) - Explanation - Simply we are returning the size of the  underneath stack which also repesents the size of out current queue data structure we are implementing. 

// Space Complexity : O(n) - Explanation - Since we are using an temporary stack for transferring the elements from the main stack back and forth. 

// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach
**/

class MyQueue {
public:
    stack<int> st;
    MyQueue() {
        
    }
    
    void push(int x) {
        st.push(x);
    }
    
    int pop() {
        stack<int> temp;
        int item;
        while(!st.empty()) {
            item = st.top();
            temp.push(item);
            st.pop();
        }
        temp.pop();
        while(!temp.empty()) {
            st.push(temp.top());
            temp.pop();
        }
        return item;
    }
    
    int peek() {
        int item;
        stack<int> temp;
        while(!st.empty()) {
            item = st.top();
            temp.push(item);
            st.pop();
        }
        while(!temp.empty()) {
            st.push(temp.top());
            temp.pop();
        }
        return item;
    }
    
    bool empty() {
        return st.empty();
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
