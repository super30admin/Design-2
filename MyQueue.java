/*
Time Complexity : O(n)  traversing entire stack while pop
Space Complexity : O(n) since we create memory of stack of elements

Did this code successfully run on Leetcode :
Finished in 60 ms
Stack Underflow
Stack Underflow
true
10
false
10
10
10
10
22
22
7
15
false
15
true

Any problem you faced while coding this :
None

Your code here along with comments explaining your approach :
Straight forward approach.

The comments after sysouts were expected output and they matched.
*/
import java.util.EmptyStackException;
import java.util.Stack;

public class MyQueue {
    Stack<Integer> stackMain;
    Stack<Integer> stackInverse;

    MyQueue(){
        stackMain = new Stack<>();
        stackInverse = new Stack<>();
    }

    public void push(int val){
        stackMain.push(val);
    }

    public int pop(){
        if(!stackInverse.isEmpty()){
            return stackInverse.pop();
        }
        while(!stackMain.isEmpty()){
            stackInverse.push(stackMain.pop());
        }
        return stackInverse.pop();
    }

    public int peek(){
        if(!stackInverse.empty()){
            return stackInverse.peek();
        }
        while(!stackMain.empty()){
            stackInverse.push(stackMain.pop());
        }
        return stackInverse.peek();
    }

    public boolean empty(){
        return stackMain.empty() && stackInverse.empty();
    }

    public static void main(String []args) {
        MyQueue myQueue = new MyQueue();
        try{
            System.out.println(myQueue.peek());//Expected Exception
        }catch(EmptyStackException ex){
            System.out.println("Stack Underflow");
        }
        try{
            System.out.println(myQueue.pop());//Expected Exception
        }catch(EmptyStackException ex){
            System.out.println("Stack Underflow");
        }

        System.out.println(myQueue.empty());//true
        myQueue.push(10);
        System.out.println(myQueue.peek());//10
        System.out.println(myQueue.empty());//false

        myQueue.push(22);
        System.out.println(myQueue.peek());//10

        myQueue.push(7);
        System.out.println(myQueue.peek());//10

        myQueue.push(15);
        System.out.println(myQueue.peek());//10

        System.out.println(myQueue.pop());//10
        System.out.println(myQueue.peek());//22
        System.out.println(myQueue.pop());//22
        System.out.println(myQueue.pop());//7
        System.out.println(myQueue.peek());//15
        System.out.println(myQueue.empty());//false
        System.out.println(myQueue.pop());//15
        System.out.println(myQueue.empty());//false
        

    }
}
