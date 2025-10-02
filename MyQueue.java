import java.util.Stack;

/**
 * 
 */

/**
 * @author Aditya Sinha
 *
 */
//we will follow 2 stack approach, one for storing original value, another for maintaining reverse values
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
public class MyQueue {

	Stack<Integer> inSt; // to maintain original values inserted
    Stack<Integer> outSt; // to maintain reverse values 
    
    public MyQueue() {
        this.inSt = new Stack<>();
        this.outSt = new Stack<>();
    }
    
    public void push(int x) { // time complexity - O(1)
        inSt.push(x);
    }
    
    public int pop() { // time complexity - O(1)
        if(empty()) return -1;
        peek();
        return outSt.pop();
    }
    
    public int peek() { // time complexity - O(1)
        if(outSt.isEmpty()){
            while(!inSt.isEmpty()){
                outSt.push(inSt.pop());
            }
        }
        return outSt.peek();
    }
    
    public boolean empty() {
        return inSt.isEmpty() && outSt.isEmpty();
    }
}

//Driver code 
class MainMyQueue { 
public static void main(String args[]) 
{ 
	MyQueue obj = new MyQueue();
	 obj.push(1);
	 obj.push(2);
	 obj.push(3);
	 obj.push(4);
	 obj.push(5);
	 obj.push(6);
	 System.out.println("top 1 - " + obj.peek());
	 obj.pop();
	 System.out.println("top 2 - " + obj.peek());
	 obj.pop();
	 System.out.println("top 3 - " + obj.peek());
	 obj.push(7);
	 obj.push(8);
	 System.out.println("top 4 - " + obj.peek());
	 obj.pop();
	 System.out.println("top 5 - " + obj.peek());
	 obj.pop();
	 System.out.println("top 6 - " + obj.peek());
	 obj.pop();
	 System.out.println("top 7 - " + obj.peek());
 
} 
}
