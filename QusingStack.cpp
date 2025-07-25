#include<iostream>
#include<stack>
using namespace std;
/*
->Implements a queue using two stacks: one for input, one for output.
->Elements are reversed from inSt to outSt only when needed.
TC:O(1), SC:O(n)
*/

class MyQueue {
    stack<int> inSt,outSt;
public:
    MyQueue() {}
    
    void push(int x){//creating a push fucntion
        inSt.push(x);
    }

    int pop() {
        if(empty()) return -1;
        peek();
        int val = outSt.top();
        outSt.pop();
        return val;
    }
    
    int peek() {
        if(outSt.empty()){
            while(!inSt.empty()){
                //pushing all the elements from inStack to outStack
                //in reverse order
                outSt.push(inSt.top());
                inSt.pop();
            }
        } 
        return outSt.top();
    }
    
    bool empty() {
        //To check if the queue is empty we have to check if both the stack are empty
        return inSt.empty() && outSt.empty();
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
int main(){

}