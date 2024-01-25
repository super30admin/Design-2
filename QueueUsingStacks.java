//time complexity push O(1), pop amortized O(1), peek amortized O(1), space complexity - O(n)
//This implementation uses two stacks, st1 for enqueuing and st2 for dequeuing.
//The push operation pushes elements onto st1.
// The pop and peek operations transfer elements from st1 to st2 if st2 is empty, ensuring the correct order for dequeuing.
//The empty operation checks if both stacks are empty.

class MyQueue {
    private Stack <Integer> st1;
    private Stack <Integer> st2;

   public MyQueue() {
       st1 = new Stack<>();
       st2 = new Stack<>();
       
   }
   
   public void push(int x) {
       st1.push(x);
       
   }
   
   public int pop() {
      peek();
      return st2.pop();

   }
   
   public int peek() {
         if(st2.isEmpty()){
           while(!st1.isEmpty()){
               st2.push(st1.pop());
           }
       }
       return st2.peek();
       
   }
   
   public boolean empty() {
       return st1.isEmpty() && st2.isEmpty();
       
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