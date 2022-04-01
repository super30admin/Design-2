package design2;
//time complexity: push: O(n), pop: O(1)
//space complexity: O(n)
import java.util.Stack;

class MyQueue {
    Stack<Integer> queue = new Stack<Integer>();
    Stack<Integer> temp = new Stack<Integer>();
    
    public void push(int ele) {  
        queue.push(ele);
    }
    
    public int pop() {
    	peek();
        return temp.pop();
    }
    
    public int peek() {
    	if(temp.isEmpty()) {
            while(!queue.isEmpty()){
                temp.push(queue.pop());
    	    }
        }
        return temp.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty() && temp.isEmpty();
    }
    
    public static void main(String args[]) {
    	MyQueue que = new MyQueue();
    	que.push(10);
    	que.push(20);
    	que.push(30);
    	que.push(40);
    	System.out.println(que.peek());
    	System.out.println(que.pop());
    	System.out.println(que.empty());
    }
}
