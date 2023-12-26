// Time Complexity :O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

//Follwed the approach discussed in class.
class MyQueue {
public:
    stack<int> st;

    MyQueue() {
        
    }
    
    void push(int x) {
        stack<int> s2;
        while(!st.empty()){
            s2.push(st.top());
            st.pop();
        }
        st.push(x);
        while(!s2.empty()){
            st.push(s2.top());
            s2.pop();
        }
    }
    
    int pop() {
        int temp = st.top();
        st.pop();
        return temp;
    }
    
    int peek() {
        return st.top();
    }
    
    bool empty() {
        return st.size() == 0;
    }
};