// used to two stacks, first stack used to push , if there is pop then remove element from first stack to second stack till will reach at the end
// and removed the last.
//time complexity: o(1) and space complexity : o(n)

class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        
        this.in = new Stack<>();
        this.out = new Stack<>();
       
    }
    
    public void push(int x) {

        this.in.push(x);
        
    }
    
    public int pop() {

        peek();
        return out.pop();
        
    }
    
    public int peek() {

       if(out.isEmpty()){
           while(!in.isEmpty())
           {
               this.out.push(in.pop());
           }

       }

       return out.peek();
        
    }
    
    public boolean empty() {
        
      return  out.isEmpty() && in.isEmpty();
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