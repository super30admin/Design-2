/*Time Complexity :
push = O(1)
pop = O(1) - Averegae Case, O(n) - worst case
peek = O(1) - Average Case, O(n) - worst case
isEmpty = O(1)
*/

/* Space Complexity :
in stack = O(n), Out Stack = O(n) -> O(n)
*/

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* Approach:
So, we can implement this using 2 stacks, 1 stack to push the elements and the other stack to 
perform peek and pop operation as queue follows FIFO Approach.
pop - to perform this first check if out stack is empty and if it is them pop elements 
from in stack and push them to out stack and remove the element from the out stack, similarly perform peek.
If it is not empty peek and pop from out stack.
Is Empty - If both stacks are empty it returns true, else return false.

*/


import java.util.*;

class QueueStack{

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public QueueStack(){

    }

    void push(int x){
        in.push(x);
    }

    int pop(){

        if(out.isEmpty()){
            while(!in.isEmpty()){
               int poppedElement = in.pop();
               out.push(poppedElement);
            }
        }
        return out.pop();
    }

    int peek(){

        if(out.isEmpty()){
            while(!in.isEmpty()){
                int poppedElement = in.pop();
                out.push(poppedElement);
            }
        }
        return out.peek();
    }

    boolean isEmpty(){
        return in.isEmpty() && out.isEmpty();
    }


    public static void main(String args[]){

        QueueStack q = new QueueStack();

        q.push(8);
        q.push(3);
        System.out.println("The top element in Queue is " + q.peek());  
        System.out.println("The popped element in Queue is " + q.pop());
        q.push(99);
        q.isEmpty();
        q.push(10);
        q.push(6);
         System.out.println("The popped element in Queue is " + q.pop());
        q.push(17);
        System.out.println("The top element in Queue is " + q.peek());
    }
        
}