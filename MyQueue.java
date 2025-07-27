/**Time Complexity: O(1) for push and isEmpty, O(n) Worst Case for pop and peek and O(1) is amortized for both operations
 * Space Complexity: O(n) for storing elements in two stacks
 * Did this code successfully run on Leetcode: Yes
 *  Any problem you faced while coding this: No
 * Approach:
 * We use two stacks to implement a queue. The first stack (`st`) is used to push elements, and the second stack (`newst`) is used to pop elements in the correct order.
 * The queue stack is populated only when it is empty and we need to pop or peek an element
 * Code redundancy is reduced by using the peek method to load the queue stack when we need to pop an element.
*/
import java.util.Stack;
class MyQueue {
    Stack<Integer> st;
    Stack<Integer> newst;
    

    public MyQueue() {
        this.st=new Stack<>();
        this.newst=new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        // if(empty()) return -1; // Handle empty queue case(not needed as constraints in leetcode say All the calls to pop and peek are valid.)
        peek(); 
        return newst.pop();
    }
    
    public int peek() {
       // if(empty()) return -1; // Handle empty queue case(not needed as constraints in leetcode say All the calls to pop and peek are valid.)
        if(newst.isEmpty())
        {
            while(!st.isEmpty())
            {
                newst.push(st.pop());
            }
        }
        return newst.peek();
        
    }
    
    public boolean empty() {
        return (st.isEmpty()&&newst.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */