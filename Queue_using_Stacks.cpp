// Time Complexity :
//           push(): O(1)
//            pop(): O(1) avg 
//                   (Worst case O(N) When ouput stack is empty and we need to transfer
//                            all the elements from input stack
//           peek(): O(1) avg
//          empty(): O(1)
// Space Complexity:
//           push(): O(N)
//            pop(): O(1)
//           peek(): O(1)
//          empty(): O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

/*
Leetcode : https://leetcode.com/problems/implement-queue-using-stacks/

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
Implement the MyQueue class:
void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
*/

/*
Code explanation : 
Queue is FIFO and Stack is LIFO

We will need two statcks. One to store incoming data and another to store outgoing data.
When we need to pop first data, we can move entire If incoming stack is popped and pushed to 
outgooing stack element by element, then top of the outgpoing stack is the fist element in the queue.
Therefore, pop on output stack works as queue is popping from front.

we need to move all data from input stack to output stack only if output stack is empty.
Time complexity for pop in Worst case is O(elements in input stack), as we will be pushing 
one element at a time from input to output stack, however avg time complexity is O(1)
*/


class MyQueue {
    stack<int> input;
    stack<int> output;

public:
    MyQueue() {

    }
    
    void push(int x) {
        input.push(x);        
    }
    
    int pop() {
        if(output.empty()){
            while(!input.empty()){
                output.push(input.top()); // output.push(input.pop()) can not be used here, as input.pop() return void.
                input.pop();
            }
        }
        int result = output.top();
        output.pop();
        return result;
    }
    
    int peek() {
        if(output.empty()){
            while(!input.empty()){
                output.push(input.top());
                input.pop();
            }
        }
        return output.top();
    }
    
    bool empty() {
        return input.empty() && output.empty();
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