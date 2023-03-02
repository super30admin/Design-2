// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : When iterating stack1 using for loop, test cases are failing. iteration part was not working, skeptical whether
//stack support for loop or is there any twist while using it.


class MyQueue {

  //declare two stacks
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        this.stack1= new Stack<>();
        this.stack2= new Stack<>();
    }
    
  //push elements in first stack i.e stack1
    public void push(int x) {
        stack1.push(x);
    }
    
  
    public int pop() {
      
      //when pop appears, check if stack2 is empty. if it is, then iterate over stack1, pop elements and then push into stack2
       if(stack2.isEmpty()){
         while(!stack1.isEmpty()){
          // for(int i=0; i<stack1.size();i++){
            stack2.push(stack1.pop()); 
        }
        }
      
      //then pop from stack2
        return stack2.pop();
    }
    
    public int peek() {
       if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
           // for(int i=0; i<=stack1.size();i++){
            stack2.push(stack1.pop()); 
        }
        }
      
     return stack2.peek();
    
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
