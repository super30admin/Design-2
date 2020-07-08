//Space Complexity : O(n)
//Stack is used for storing elements
//Time Complexity : O(n)
              //  Push O(1)
               // Pop O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

               class MyQueue {

                //1.Create two stacks
                //2.Push elements in stack1 till pop and peek operation didn't occur
                //3. On peek and Pop push all elements from stack1 to stack2 if stack2 is empty
                //4. Perform pop and peek accordingly
                
                Stack<Integer> stack1;
                Stack<Integer> stack2;
                /** Initialize your data structure here. */
                public MyQueue() {
                    stack1= new Stack<>();
                    stack2= new Stack<>();       
                }
                
                /** Push element x to the back of queue. */
                public void push(int x) {
                    stack1.push(x);
                    
                }
                
                /** Removes the element from in front of queue and returns that element. */
                public int pop() {
                    if(stack2.isEmpty()){
                       while(!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                    }
                    return stack2.pop();
                   
                }
                
                /** Get the front element. */
                public int peek() {
                    if(stack2.isEmpty()){
                        while(!stack1.isEmpty()){
                            stack2.push(stack1.pop());
                        }
                    }
                    return stack2.peek();
                    
                }
                
                /** Returns whether the queue is empty. */
                public boolean empty() {
                    return stack1.isEmpty()&&stack2.isEmpty();    }
            }
            
            /**
             * Your MyQueue object will be instantiated and called as such:
             * MyQueue obj = new MyQueue();
             * obj.push(x);
             * int param_2 = obj.pop();
             * int param_3 = obj.peek();
             * boolean param_4 = obj.empty();
             */