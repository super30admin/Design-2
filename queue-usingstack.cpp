// Time Complexity : O(1) amorotized, peek need to shift all of the elemnts to output stack but not it all cases
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// leetcode(232): https://leetcode.com/problems/implement-queue-using-stacks/
/* Approach: This sol uses two stacks to imitate a queue. new item go to inStack and when need to pop or 
peek, the values are shifted to outsack so the order become reversed: can asses first elements first. This shifting does
not happen everytime, so overall operation are O(1)*/

#include<iostream>

using namespace std;
class MyQueue {
private:
    stack<int> inStack, outStack; //created two stack one to hold the input and another to hold outputs
public:
    MyQueue(){
        
    }
    
    void push(int x) {
        //push value to the input stack;
        inStack.push(x);
    }
    
    int pop() {
        //transfer all the elements using peek method to outStack and pop the top one
        int currTop = peek();

        outStack.pop();
        return currTop;
    }
    
    int peek() {
        if(outStack.empty()){//if output stack is not empty then
            while(!inStack.empty()){
                outStack.push(inStack.top());//access the top elemt using top(): c++ is weird
                inStack.pop();
            }
        }

        return outStack.top();//peek in another langs
    }
    
    bool empty() {
        //if both input and output stacks are empty then its empty
        return inStack.empty() && outStack.empty();
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