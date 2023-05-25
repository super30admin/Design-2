/* Amortized Time Complexity: O(1): 
Space Complexity: O(1)*/

/* Approach: Take two stacks 'in' and 'out' .
For push:  Keep pushing into stack 'in'. 
For pop: First when pop() is encountered, copy elements from 'in' to 'out' and pop the top element from 'out' stack.

Even though for pop() worst case time complexity is O(n) but we consider amortized version. Hence on average case it will be O(1)
*/


class MyQueue {

    //Creating two stacks
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        this.in=new Stack<>();
        this.out=new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        peek();
        return out.pop();
    }
    
    public int peek() {
       if(out.isEmpty())
            while(!in.isEmpty())
                out.push(in.pop());
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
