// Time Complexity :
// push() : O(1)
// pop() : Amortized O(1); worst case (n)
// peek() : Amortized O(1); worst case (n)
// empty() : O(1)

// Space Complexity :
// push() : O(n)
// pop() : Amortized O(1); worst case (n)
// peek() : Amortized O(1); worst case (n)
// empty : O(1)

// Constraints:
// 1 <= x <= 9
// At most 100 calls will be made to push, pop, peek, and empty.
// All the calls to pop and peek are valid.

import java.util.Stack;

public class MyQueue {

    Stack<Integer> primaryStack;
    Stack<Integer> secondaryStack;
    public MyQueue() {
        primaryStack = new Stack<>();
        secondaryStack = new Stack<>();
    }

    public void push(int x) {
        primaryStack.push(x);
    }

    public int pop() {
        if(secondaryStack.empty()) {
            if(primaryStack.empty()){
                return -1;
            }
            else{
                while(!primaryStack.empty()){
                    secondaryStack.push(primaryStack.pop());
                }
            }
        }
        return secondaryStack.pop();
    }

    public int peek() {
        if(secondaryStack.empty()) {
            if(primaryStack.empty()){
                return -1;
            }
            else{
                while(!primaryStack.empty()){
                    secondaryStack.push(primaryStack.pop());
                }
            }
        }
        return secondaryStack.peek();
    }

    public boolean empty() {
        if(secondaryStack.empty()){
            if(primaryStack.empty()){
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
//        obj.push(x);
//        int param_2 = obj.pop();
//        int param_3 = obj.peek();
//        boolean param_4 = obj.empty();

        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }
}
