// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Got error for edge case when stack is empty. 


// Your code here along with comments explaining your approach:
// 1. Used 2 stacks to implement queue. 
// 2. p is a variable to kepp track of peek element.
// 3. while pop() operation all elements in s1 is popped to s2.
// 4. s2's top() element is popped and again all elements are shifted from s2 to s1.

class MyQueue {
public:
    stack<int> s1,s2;
    int p;
    MyQueue() {
        p=-1;
    }
    
    void push(int x) {
        s1.push(x);
        if(p==-1){
            p=x;
        }
    }
    
    int pop() {
        int fs=s1.size();
        for(int i=0;i<fs;i++){
            s2.push(s1.top());
            s1.pop();
        }
        int aa=s2.top();
        s2.pop();
        if(s2.empty()){
            p=-1;
        }else{
        p=s2.top();}
        for(int i=1;i<fs;i++){
            s1.push(s2.top());
            s2.pop();
        }
        //cout<<s1.empty();
        return aa;
    }
    
    int peek() {
        return p;
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