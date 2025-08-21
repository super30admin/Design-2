// Time Complexity : O(1) for push, pop, peek and empty
// Space Complexity : O(1) for user facing functions, O(n) overall
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We use an in stack and an out stack.
// we push elements to the in stack always, and when we need to pop, we empty out the contents of the in stack into the out stack and then pop & return the top element of the out stack.
// We use the same logic for peek (empty contents of in stack into out stack, return top element of out stack), for empty we just check if both the stacks are empty or not.

#include <stack>
#include <iostream>
using namespace std;

class MyQueue {
private:
    stack<int> in;
    stack<int> out;
public:
    MyQueue() = default;
    
    void push(int x) { // simply push into in stack
        in.push(x);
    }
    
    int pop() {
        int returnVal = peek(); // this will empty in stack into out stack and give the top element
        out.pop(); // pop the top element
        return returnVal; // return popped value
    }
    
    int peek() {
        if(out.empty()){ // check if out has no elements
            while(!in.empty()) { // empty in stack into out stack
                out.push(in.top());
                in.pop();
            }
        }
        return out.top(); // return top element of the out stack
    }
    
    bool empty() {
        return in.empty() && out.empty(); // check if both in stack and out stack are empty
    }
};

int main() {
    MyQueue queue;
    cout<< (queue.empty() ? "Queue is empty." : "Queue is not empty.") <<endl;
    queue.push(1);
    cout<< "Pushing 1..."<<endl;
    queue.push(2);
    cout<<"Pushing 2..."<<endl;
    queue.push(3);
    cout<<"Pushing 3..."<<endl;
    cout<<"Popped " << queue.pop() <<endl;
    cout<<"Peek: "<< queue.peek() <<endl;
    cout<< (queue.empty() ? "Queue is empty." : "Queue is not empty.") <<endl;
 }