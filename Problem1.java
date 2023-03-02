//Time Complexity : O(1)
//Space Complexity : O(n)
class MyQueue {
    Stack<Integer> Queue_front;
    Stack<Integer> Queue_back;
     
    public MyQueue() {
        Queue_front= new Stack<Integer>();
        Queue_back= new Stack<Integer>();
        
    }
    
    public void push(int x) {
       Queue_back.push(x);  
    }
    
    public int pop() {
        
       if(Queue_front.isEmpty())
       {
          while(!Queue_back.isEmpty())
          { 
           Queue_front.push(Queue_back.pop());
          }
       }
    

       return Queue_front.pop(); 
    }
    
    public int peek() {
        if(Queue_front.isEmpty())
        {  
            while(!Queue_back.isEmpty())
            { 
            Queue_front.push(Queue_back.pop());
            }
        }
        return Queue_front.peek();
    }
    
    public boolean empty() {
        if(Queue_front.isEmpty() && Queue_back.isEmpty())
        return true;
        else return false;
        
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
